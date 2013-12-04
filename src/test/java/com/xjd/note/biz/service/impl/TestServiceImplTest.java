package com.xjd.note.biz.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjd.note.biz.service.TestService;

public class TestServiceImplTest extends ServiceBaseTest {

	@Autowired
	TestService testServiceImpl;
	
	@Test
	public void testTestAnnotation() throws SecurityException, NoSuchMethodException {
		testServiceImpl.testAnnotation("A");
		testServiceImpl.testAnnotation("A");
		
		testServiceImpl.testAny("A");
		testServiceImpl.testAny("A");
	}

}
