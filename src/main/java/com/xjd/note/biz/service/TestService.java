package com.xjd.note.biz.service;

import org.springframework.cache.annotation.Cacheable;

public interface TestService {

	@Cacheable("test")
	public String testAnnotation(String s);
}
