package com.xjd.note.dao;

/**
 * <pre>
 * 查询权限的类型
 * </pre>
 * 
 * @author elvis.xu
 * @since 2013-11-19
 */
public enum AuthTypeEnum {
	ALL("0", "所有权限(包括权限组)"),
	ONLY_AUTHORITY("1", "仅仅权限"),
	ONLY_GROUP("2", "仅权限组");

	private String code;
	private String name;

	AuthTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
