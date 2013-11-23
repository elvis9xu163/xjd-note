package com.xjd.note.biz.exception;

/**
 * <pre>
 * 授权异常类
 * </pre>
 * 
 * @author elvis.xu
 * @since 2013-11-20
 */
public class AuthException extends Exception {
	private static final long serialVersionUID = 7542582358375230857L;

	private String code;
	private String msg;
	
	public AuthException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
