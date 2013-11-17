package com.xjd.note.biz.service.impl;

import javax.annotation.PostConstruct;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.component.TestAnnotation;
import com.xjd.note.biz.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	protected Validator validator;
	
	@PostConstruct
	protected void print() {
		System.out.println(validator);
	}

	@Override
	@TestAnnotation("HAVE")
	public String testAnnotation(String s) {
		System.out.println("testAnnotation method called!");
		return "hello";
	}
	
}
