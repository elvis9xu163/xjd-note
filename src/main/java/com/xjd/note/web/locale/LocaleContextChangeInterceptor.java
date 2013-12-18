package com.xjd.note.web.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * <pre>
 * Interceptor that allows for changing the current thread locale on every request, via a configurable session spring attribute.
 * </pre>
 * @author elvis.xu
 * @since 2013-12-4
 * @see org.springframework.web.servlet.i18n.SessionLocaleResolver
 * @see org.springframework.web.servlet.i18n.LocaleChangeInterceptor
 * @see org.springframework.context.i18n.LocaleContextHolder
 */
public class LocaleContextChangeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Locale locale;
		HttpSession session = request.getSession(false);

		locale = session == null ? null : (Locale) session
				.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		locale = locale == null ? request.getLocale() : locale;

		if (locale != null) {
			LocaleContextHolder.setLocale(locale);
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LocaleContextHolder.resetLocaleContext();
	}

}
