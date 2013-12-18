package com.xjd.note.web.auth;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * <pre>
 * 授权相关配置类
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:24:56 PM
 */
@Component
public class AuthConfig {
	private static final Logger log = LoggerFactory.getLogger(AuthConfig.class);
	
	public static final String DEFAULT_AUTH_COOKIE_NAME = "authCookie";
	public static final String DEFAULT_AUTH_VAR_NAME = "auth";
	public static final String DEFAULT_AUTH_FAIL_PATH = "/auth/login/input";
	
	@Value("#{properties['auth.ignorePathPattern']}")
	private String ignorePathPatternStr;
	
	@Value("#{properties['auth.authCookieName']}")
	private String authCookieNameStr;
	
	@Value("#{properties['auth.authVarName']}")
	private String authVarNameStr;
	
	@Value("#{properties['auth.authFailPath']}")
	private String authFailPathStr;
	
	protected String[] ignorePathPatterns;
	protected String authCookieName = DEFAULT_AUTH_COOKIE_NAME;
	protected String authVarName = DEFAULT_AUTH_VAR_NAME;
	protected String authFailPath = DEFAULT_AUTH_FAIL_PATH;
	
	protected PathMatcher pathMatcher = new AntPathMatcher();
	
	/**
	 * <pre>
	 * 初始化
	 * </pre>
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:25:39 PM
	 */
	@PostConstruct
	public void init() {
		log.info("initializing...");
		
		log.info("loaded property: auth.ignorePathPattern={}", ignorePathPatternStr);
		log.info("loaded property: auth.authCookieName={}", authCookieNameStr);
		log.info("loaded property: auth.authVarName={}", authVarNameStr);
		log.info("loaded property: auth.authFailPath={}", authFailPathStr);
		
		if (!StringUtils.isBlank(authCookieNameStr)) {
			authCookieName = authCookieNameStr.trim();
		}
		
		if (!StringUtils.isBlank(authVarNameStr)) {
			authVarName = authVarNameStr.trim();
		}
		
		if (!StringUtils.isBlank(authFailPathStr)) {
			authFailPath = authFailPathStr.trim();
		}

		if (!StringUtils.isBlank(ignorePathPatternStr)) {
			ignorePathPatterns = ArrayUtils.add(ignorePathPatternStr.trim().split("[,\\s]+"), authFailPath);
		}
	}

	public String[] getIgnorePathPatterns() {
		return ignorePathPatterns;
	}

	public String getAuthCookieName() {
		return authCookieName;
	}

	public String getAuthVarName() {
		return authVarName;
	}

	public String getAuthFailPath() {
		return authFailPath;
	}
	
	/**
	 * <pre>
	 * 判断给定的路径是否在忽略路径内
	 * </pre>
	 * @param path
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:25:57 PM
	 */
	public String findMatchIgnorePattern(String path) {
		if (ignorePathPatterns != null) {
			for (String ignorePathPatt : ignorePathPatterns) {
				if (pathMatcher.match(ignorePathPatt, path)) { //无需授权
					return ignorePathPatt;
				}
			}
		}
		return null;
	}
	
}
