package com.xjd.note.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjd.note.web.model.TestVo;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/jsp")
	public String test() {
		return "/test";
	}
	
	@RequestMapping("/string")
	@ResponseBody
	public String testString() {
		return "这是String测试";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Object testJson() {
		Map map = new HashMap();
		map.put("HELLO", "您好!");
		return map;
	}
	
	@RequestMapping("/json2")
	@ResponseBody
	public Object testJson2() {
		List list = new ArrayList();
		list.add("HELLO");
		list.add("您好!");
		return list;
	}
	
	@RequestMapping("/xml")
	@ResponseBody
	public Object testXml() {
		TestVo testVo = new TestVo();
		testVo.setName("我");
		testVo.setAge(300);
		testVo.setMsg("爱你");
		return testVo;
	}
}
