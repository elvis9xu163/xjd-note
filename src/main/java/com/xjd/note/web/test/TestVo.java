package com.xjd.note.web.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestVo {

	private String name;
	private int age;
	private String msg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
