package com.xjd.note.biz.service.impl;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;

import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.service.AuthService;
import com.xjd.note.biz.service.CryptService;
import com.xjd.note.dao.mapper.UserDoMapper;
import com.xjd.note.dao.model.UserDoExample;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @since 2013-12-2
 */
public class AuthServiceImpl implements AuthService {
	
	Charset charset = Charset.forName("UTF-8");
	
	@Autowired
	UserDoMapper userDoMapper;
	
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
	public Auth login(String nameOrMail, String password) {
		String encodedPassword = encodePassword(password);
		
		return null;
	}

	protected String encodePassword(String password) {
		return cryptService.bytes2EncodedString(cryptService.digest(password.getBytes(charset)));
	}
}
