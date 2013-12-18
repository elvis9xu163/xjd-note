package com.xjd.note.biz.component.auth;

import com.xjd.note.biz.model.Auth;

/**
 * <pre>
 * 授权对象的线程持有器
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:00:19 PM
 */
public abstract class AuthHolder {

	protected static ThreadLocal<Auth> authThreadLocal = new ThreadLocal<Auth>();
	
	/**
	 * <pre>
	 * 设置线程授权对象
	 * </pre>
	 * @param auth
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:04:35 PM
	 */
	public static void set(Auth auth) {
		authThreadLocal.set(auth);
	}
	
	/**
	 * <pre>
	 * 获取线程授权对象
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:04:59 PM
	 */
	public static Auth get() {
		return authThreadLocal.get();
	}
	
	/**
	 * <pre>
	 * 清除线程授权对象
	 * </pre>
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:05:08 PM
	 */
	public static void reset() {
		authThreadLocal.remove();
	}
}
