package com.xjd.note.biz.exception;

public enum AuthExceptionType {
	USER_NOT_EXISTS(10, "User not exists."),
	
	WRONG_USERNAME_OR_PASSWORD(20, "Wrong username or password."),
	
	NOT_HAS_AUTHORITY(30, "Not has authority \"{0}\""),
	
	NO_AUTHORITY_SET(31, "Need authorizing, but no authority set."),
	
	NOT_SATISFY_AUTH_EXPRESSION(40, "Not satisfy auth-expression \"{0}\""),
	
	NO_AUTH_EXPRESSION_SET(41, "Need authorizing, but no auth-expression set."),
	
	UNEXPECTED_EXCEPTION(90, "Unexpected exception.")
	
	;
	
	int code;
	String msg;
	
	AuthExceptionType(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
