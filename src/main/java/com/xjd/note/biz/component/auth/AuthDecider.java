package com.xjd.note.biz.component.auth;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.model.Authority;

@Component
public class AuthDecider {

	protected Auth getAuth() {
		return AuthHolder.get();
	}
	
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
	
	public boolean anonymous() {
		return getAuth() == null;
	}
	
	public boolean logedon() {
		return getAuth() != null;
	}
	
	protected boolean contains(List<Authority> authorities, String authStr) {
		for (Authority authority : authorities) {
			if (isEqual(authority, authStr)) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean isEqual(Authority authority, String authStr) {
		return StringUtils.equals(authStr, authority.getAuthorityCode()) || StringUtils.equals(authStr, authority.getAuthorityName());
	}
}
