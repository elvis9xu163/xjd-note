package com.xjd.note.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CacheHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private HttpServletResponse httpServletResponse;
	
	public CacheHttpServletRequestWrapper(HttpServletRequest request, HttpServletResponse response) {
		super(request);
	}

	@Override
	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return super.getRequestedSessionId();
	}

	@Override
	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return super.getSession(create);
	}

	@Override
	public HttpSession getSession() {
		return getSession(true);
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return super.isRequestedSessionIdValid();
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return super.isRequestedSessionIdFromCookie();
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return super.isRequestedSessionIdFromURL();
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return super.isRequestedSessionIdFromUrl();
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

}
