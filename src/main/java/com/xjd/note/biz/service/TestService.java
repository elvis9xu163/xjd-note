package com.xjd.note.biz.service;

import org.springframework.cache.annotation.Cacheable;

import com.xjd.note.biz.component.TestAnnotation;

public interface TestService {

	@Cacheable("test")
	public String testAnnotation(String s);
}
