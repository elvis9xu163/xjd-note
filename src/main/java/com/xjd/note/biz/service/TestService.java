package com.xjd.note.biz.service;

import org.springframework.cache.annotation.Cacheable;

import com.xjd.note.biz.component.auth.PreAuthorize;
import com.xjd.note.biz.component.test.TestAnnotation;

public interface TestService {

	@Cacheable("test")
	@TestAnnotation("test")
	public String testAnnotation(String s);
	
	public String testAny(String s);
	
	@PreAuthorize("test")
	public void testAuth();
	
	@PreAuthorize(value="any('test', 'good')", isExpression=true)
	public void testAuthAny();
	
	@PreAuthorize(value="all('test', 'good')", isExpression=true)
	public void testAuthAll();
}
