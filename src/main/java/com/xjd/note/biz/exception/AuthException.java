package com.xjd.note.biz.exception;

import java.text.MessageFormat;

/**
 * <pre>
 * 授权异常类
 * </pre>
 * @author elvis.xu
 * @since 2013-11-20
 */
public class AuthException extends Exception {
	private static final long serialVersionUID = 7542582358375230857L;

	protected AuthExceptionType eType;
	private String[] args;
	private MessageFormat format;

	public AuthException(AuthExceptionType eType) {
		this.eType = eType;
	}

	public AuthException(AuthExceptionType eType, String... args) {
		this(eType);
		this.args = args;
	}

	public AuthExceptionType getType() {
		return eType;
	}

	public int getCode() {
		return eType.getCode();
	}

	/**
	 * <pre>
	 * 获取消息模板
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:07:16 PM
	 */
	public String getMsgTemplate() {
		return eType.getMsgTemplate();
	}

	/**
	 * <pre>
	 * 获取替换占位符后的消息
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:12:20 PM
	 */
	public String getMsg() {
		if (args == null || args.length == 0) {
			return getMsgTemplate();
		}
		if (format == null) {
			format = new MessageFormat(getMsgTemplate());
		}
		return format.format(args);
	}

	public String[] getArgs() {
		return args;
	}

	@Override
	public String toString() {
		return "AuthException [code=" + getCode() + ", msg=" + getMsg() + "]";
	}
}
