package com.xjd.note.web.auth;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xjd.note.biz.service.CryptService;



@Component("authFilter")
public class AuthFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(AuthFilter.class);
	
	public static final String IGNORE_URL_PATTERN_KEY = "ignoreUrlPattern";
	public static final String AUTH_COOKIE_NAME_KEY = "authCookieName";
	public static final String AUTH_VAR_NAME_KEY = "authVarName";
	public static final String DEFAULT_AUTH_COOKIE_NAME = "authCookie";
	public static final String DEFAULT_AUTH_VAR_NAME = "auth";
	
	protected String[] ignoreUrlPatterns;
	protected String authCookieName = DEFAULT_AUTH_COOKIE_NAME;
	protected String authVarName = DEFAULT_AUTH_VAR_NAME;
	
	@Autowired
	protected CryptService cryptService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("initializing...");
		
		String ignoreUrlPatternStr = filterConfig.getInitParameter(IGNORE_URL_PATTERN_KEY);
		log.info("读取到初始参数: {}='{}'", IGNORE_URL_PATTERN_KEY, ignoreUrlPatternStr);
		if (!StringUtils.isBlank(ignoreUrlPatternStr)) {
			ignoreUrlPatterns = ignoreUrlPatternStr.trim().split("[,\\s]+");
			if (log.isDebugEnabled()) {
				log.debug("解析初始参数: {}={}", IGNORE_URL_PATTERN_KEY, Arrays.toString(ignoreUrlPatterns));
			}
		}
		
		String authCookieNameStr = filterConfig.getInitParameter(AUTH_COOKIE_NAME_KEY);
		log.info("读取到初始参数: {}='{}'", AUTH_COOKIE_NAME_KEY, authCookieNameStr);
		if (!StringUtils.isBlank(authCookieNameStr)) {
			authCookieName = authCookieNameStr.trim();
		}
		
		String authVarNameStr = filterConfig.getInitParameter(AUTH_VAR_NAME_KEY);
		log.info("读取到初始参数: {}='{}'", AUTH_VAR_NAME_KEY, authVarNameStr);
		if (!StringUtils.isBlank(authVarNameStr)) {
			authVarName = authVarNameStr.trim();
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		Object auth = httpRequest.getAttribute(authVarName);
		if (auth != null) { //授权成功
			chain.doFilter(httpRequest, response);
			
		} else {
			
		}
	}

	@Override
	public void destroy() {
		// Do-Nothing
	}

}
