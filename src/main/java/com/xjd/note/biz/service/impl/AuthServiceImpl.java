package com.xjd.note.biz.service.impl;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.exception.AuthException;
import com.xjd.note.biz.exception.AuthExceptionType;
import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.model.Authority;
import com.xjd.note.biz.model.User;
import com.xjd.note.biz.service.AuthService;
import com.xjd.note.biz.service.CryptService;
import com.xjd.note.dao.AuthTypeEnum;
import com.xjd.note.dao.mapper.UserDoMapper;
import com.xjd.note.dao.mapper.custom.AuthDoMapper;
import com.xjd.note.dao.model.AuthorityDo;
import com.xjd.note.dao.model.UserDo;
import com.xjd.note.dao.model.UserDoExample;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @since 2013-12-2
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	Charset charset = Charset.forName("UTF-8");
	
	@Autowired
	UserDoMapper userDoMapper;
	
	@Autowired
	AuthDoMapper authMapper;
	
	@Autowired
	CryptService cryptService;

	@Override
	public boolean existsUsernameOrEmail(String nameOrMail) {
		UserDoExample exp = new UserDoExample();
		exp.createCriteria().andUsernameEqualTo(nameOrMail);
		exp.or().andEmailEqualTo(nameOrMail);
		
		return userDoMapper.selectByExample(exp).size() > 0;
	}

	@Override
	public Auth login(String nameOrMail, String password) throws AuthException {
		String encodedPassword = encodePassword(password);
		
		UserDoExample exp = new UserDoExample();
		exp.createCriteria().andUsernameEqualTo(nameOrMail).andPasswordEqualTo(encodedPassword);
		exp.or().andEmailEqualTo(nameOrMail).andPasswordEqualTo(encodedPassword);
		
		List<UserDo> userDos = userDoMapper.selectByExample(exp);
		
		if (userDos.size() > 1) {
		    throw new AuthException(AuthExceptionType.UNEXPECTED_EXCEPTION);
		}
		
		if (userDos.size() < 1) {
		    throw new AuthException(AuthExceptionType.WRONG_USERNAME_OR_PASSWORD);
		}
		
		Auth auth = new Auth();
		
		User user = new User();
		BeanUtils.copyProperties(userDos.get(0), user);
		user.setPassword(null); //密码置空
		auth.setUser(user);
		
		List<AuthorityDo> authorityDos = authMapper.queryAuthoritiesForUser(user.getId(), AuthTypeEnum.ALL.getCode());
		List<Authority> authorities = new ArrayList<Authority>(authorityDos.size());
		for (AuthorityDo authorityDo : authorityDos) {
		    Authority authority = new Authority();
		    BeanUtils.copyProperties(authorityDo, authority);
		    authorities.add(authority);
		}
		auth.setAuthorities(authorities);
		
		return auth;
	}

	protected String encodePassword(String password) {
		return cryptService.bytes2EncodedString(cryptService.digest(password.getBytes(charset)));
	}
}
