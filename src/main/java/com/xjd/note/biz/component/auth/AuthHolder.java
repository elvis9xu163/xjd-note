package com.xjd.note.biz.component.auth;

import com.xjd.note.biz.model.Auth;

public abstract class AuthHolder {

	protected static ThreadLocal<Auth> authThreadLocal = new ThreadLocal<Auth>();
	
	public static void set(Auth auth) {
		authThreadLocal.set(auth);
	}
	
	public static Auth get() {
		return authThreadLocal.get();
	}
	
	public static void reset() {
		authThreadLocal.remove();
	}
}
