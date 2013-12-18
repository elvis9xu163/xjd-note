package com.xjd.note.biz.component.auth;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.model.Authority;

/**
 * <pre>
 * 授权检查类
 * 决定是否授权
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 2:56:57 PM
 */
@Component
public class AuthDecider {

	protected Auth getAuth() {
		return AuthHolder.get();
	}

	/**
	 * <pre>
	 * 满足任意权限即可认为授权通过
	 * </pre>
	 * @param authorities
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 2:57:30 PM
	 */
	public boolean any(String... authorities) {
		Auth auth = getAuth();
		if (auth != null && auth.getAuthorities() != null) {
			for (String authority : authorities) {
				if (contains(auth.getAuthorities(), authority)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <pre>
	 * 满足所有权限才可认为授权通过
	 * </pre>
	 * @param authorities
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 2:58:23 PM
	 */
	public boolean all(String... authorities) {
		Auth auth = getAuth();
		if (auth != null && auth.getAuthorities() != null) {
			for (String authority : authorities) {
				if (!contains(auth.getAuthorities(), authority)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * <pre>
	 * 必须未登录
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 2:58:49 PM
	 */
	public boolean anonymous() {
		return getAuth() == null;
	}

	/**
	 * <pre>
	 * 必须登录
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 2:59:04 PM
	 */
	public boolean logedon() {
		return getAuth() != null;
	}

	/**
	 * <pre>
	 * 是否有给定的权限
	 * </pre>
	 * @param authorities
	 * @param authStr
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 2:59:20 PM
	 */
	protected boolean contains(List<Authority> authorities, String authStr) {
		for (Authority authority : authorities) {
			if (isEqual(authority, authStr)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <pre>
	 * 权限字符串是否是指定权限
	 * </pre>
	 * @param authority
	 * @param authStr
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 2:59:40 PM
	 */
	protected boolean isEqual(Authority authority, String authStr) {
		return StringUtils.equals(authStr, authority.getAuthorityCode())
				|| StringUtils.equals(authStr, authority.getAuthorityName());
	}
}
