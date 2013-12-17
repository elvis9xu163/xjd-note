package com.xjd.note.biz.exception;

import java.text.MessageFormat;

/**
 * <pre>
 * 授权异常类
 * </pre>
 * 
 * @author elvis.xu
 * @since 2013-11-20
 */
public class AuthRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 7542582358375230857L;
	
	protected AuthExceptionType eType;
	private String[] args;
	private MessageFormat format;

	public AuthRuntimeException(AuthExceptionType eType) {
		this.eType = eType;
	}

	public AuthRuntimeException(AuthExceptionType eType, String... args) {
		this(eType);
		this.args = args;
	}

	public AuthExceptionType getType() {
		return eType;
	}

	public int getCode() {
		return eType.getCode();
	}

	public String getOriginalMsg() {
		return eType.getMsg();
	}

	public String getMsg() {
		if (args == null || args.length == 0) {
			return getOriginalMsg();
		}
		if (format == null) {
			format = new MessageFormat(getOriginalMsg());
		}
		
		return format.format(args);
	}

	public String[] getArgs() {
		return args;
	}

	@Override
	public String toString() {
		return "AuthRuntimeException [code=" + getCode() + ", msg=" + getMsg() + "]";
	}
}
