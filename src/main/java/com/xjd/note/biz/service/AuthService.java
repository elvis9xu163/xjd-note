package com.xjd.note.biz.service;

import org.springframework.cache.annotation.Cacheable;

import com.xjd.note.biz.exception.AuthException;
import com.xjd.note.biz.model.Auth;

/**
 * <pre>
 * 权限服务
 * </pre>
 * @author elvis.xu
 * @since 2013-11-20
 */
public interface AuthService {

	/**
	 * <pre>
	 * 注册的用户名或邮箱是否已存在
	 * 用户名和邮箱都必须是唯一的
	 * </pre>
	 * @param nameOrMail
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-20
	 */
	@Cacheable(value="auth")
	public boolean existsUsernameOrEmail(String nameOrMail);
	
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param nameOrMail
	 * @param password
	 * @return
	 * @author elvis.xu
	 * @since 2013-11-20
	 */
	@Cacheable(value="auth")
	public Auth login(String nameOrMail, String password) throws AuthException;
}
