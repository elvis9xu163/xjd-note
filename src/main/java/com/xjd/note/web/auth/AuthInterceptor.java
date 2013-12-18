package com.xjd.note.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xjd.note.biz.component.auth.AuthHolder;
import com.xjd.note.biz.model.Auth;

/**
 * <pre>
 * Interceptor that allows for setting current thread 'auth' object
 * to authorize the subsequent operation.
 * </pre>
 * @author elvis.xu
 * @since 2013-12-5
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	AuthConfig authConfig;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object authObj = session.getAttribute(authConfig.getAuthVarName());
			if (authObj != null) {
				if (!(authObj instanceof Auth)) {
					throw new RuntimeException("auth object is not an Auth instance [" + authObj + "]");
				}
				AuthHolder.set((Auth) authObj);
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		AuthHolder.reset();
	}

}
