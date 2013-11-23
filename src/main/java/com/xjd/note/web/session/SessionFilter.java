package com.xjd.note.web.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("sessionFilter")
public class SessionFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(SessionFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("initializing...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			request = new CacheHttpServletRequestWrapper((HttpServletRequest)request, (HttpServletResponse)response);
			log.debug("The request has been wrapped.");
		} else {
			log.warn("Can not wrap request! Be sure the request/response is instance of HttpServletRequest/HttpServletResponse.");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Do-Nothing
	}

}
