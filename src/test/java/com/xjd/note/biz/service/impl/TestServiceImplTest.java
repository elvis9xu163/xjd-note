package com.xjd.note.biz.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjd.note.biz.service.TestService;

public class TestServiceImplTest extends ServiceBaseTest {

	@Autowired
	TestService testService;
	
	@Test
	public void testTestAnnotation() throws SecurityException, NoSuchMethodException {
		testService.testAnnotation("A");
		testService.testAnnotation("A");
		
		testService.testAny("A");
		testService.testAny("A");
	}

	@Test
	public void testAuth() {
		try {
			testService.testAuth();
			testService.testAuthAny();
			testService.testAuthAll();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
