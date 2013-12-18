package com.xjd.note.biz.service.impl;

import javax.annotation.PostConstruct;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.component.test.TestAnnotation;
import com.xjd.note.biz.service.TestService;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:20:58 PM
 */
@Service
public class TestServiceImpl implements TestService {
	private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

	@Autowired
	protected Validator validator;

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:21:01 PM
	 */
	@PostConstruct
	protected void print() {
		log.debug("" + validator);
	}

	@Override
	@TestAnnotation("HAVE")
	public String testAnnotation(String s) {
		log.debug("called!");
		return "hello";
	}

	@Override
	public String testAny(String s) {
		log.debug("called!");
		return null;
	}

	@Override
	public void testAuth() {

	}

	@Override
	public void testAuthAny() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testAuthAll() {
		// TODO Auto-generated method stub

	}

}
