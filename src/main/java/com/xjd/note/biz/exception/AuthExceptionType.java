package com.xjd.note.biz.exception;

/**
 * <pre>
 * 授权异常种类枚举
 * </pre>
 * @author elvis.xu
 * @since Dec 17, 2013 1:57:16 PM
 */
public enum AuthExceptionType {
	USER_NOT_EXISTS(10, "User not exists."),
	
	WRONG_USERNAME_OR_PASSWORD(20, "Wrong username or password."),
	
	NOT_HAS_AUTHORITY(30, "Not has authority \"{0}\""),
	
	NO_AUTHORITY_SET(31, "Need authorizing, but no authority set."),
	
	NOT_SATISFY_AUTH_EXPRESSION(40, "Not satisfy auth-expression \"{0}\""),
	
	NO_AUTH_EXPRESSION_SET(41, "Need authorizing, but no auth-expression set."),
	
	UNEXPECTED_EXCEPTION(90, "Unexpected exception.")
	;
	
	/**
	 * 代码
	 * @author elvis.xu
	 */
	int code;
	/**
	 * 消息模板
	 * @author elvis.xu
	 */
	String msgTemplate;
	
	AuthExceptionType(int code, String msgTemplate) {
		this.code = code;
		this.msgTemplate = msgTemplate;
	}

	public int getCode() {
		return code;
	}

	public String getMsgTemplate() {
		return msgTemplate;
	}
}
