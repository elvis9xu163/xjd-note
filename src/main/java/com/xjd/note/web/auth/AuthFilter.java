package com.xjd.note.web.auth;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xjd.note.biz.service.CryptService;



@Component("authFilter")
public class AuthFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(AuthFilter.class);
	
	@Autowired
	AuthConfig authConfig;
	
	@Autowired
	protected CryptService cryptService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do-Nothing
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		if (session != null && session.getAttribute(authConfig.getAuthVarName()) != null) { //授权成功
			log.debug("已授权.");
			chain.doFilter(httpRequest, response);
			
		} else { //无授权信息
			String path = getRequestPath(httpRequest);
			String patt = authConfig.findMatchIgnorePattern(path);
			if (patt == null) {
				//需要授权
				log.debug("需要授权: path={}", path);
				path = URLEncoder.encode(path, "UTF-8"); //中文转码
				((HttpServletResponse) response).sendRedirect(getAuthFailPath(httpRequest, authConfig.getAuthFailPath(), path));
			} else {
				log.debug("无需授权: path={}, pattern={}", path, patt);
				chain.doFilter(httpRequest, response);
			}
		}
	}
	
	protected String getRequestPath(HttpServletRequest req) {
		String servletPath = req.getServletPath();
		String pathInfo = req.getPathInfo();
		StringBuilder reqPath = new StringBuilder();
		if (!"".equals(servletPath) && !"/".equals(servletPath)) {
			reqPath.append(servletPath);
		}
		if (pathInfo != null) {
			reqPath.append(pathInfo);
		}
		if ("".equals(reqPath.toString())) { //如果没有任何路径则是根路径
			reqPath.append("/");
		}
		return reqPath.toString();
	}
	
	protected String getAuthFailPath(HttpServletRequest req, String authFailPath, String targetPath) {
		return req.getContextPath() + authFailPath + "?targetPath=" + targetPath;
	}

	@Override
	public void destroy() {
		// Do-Nothing
	}

}
