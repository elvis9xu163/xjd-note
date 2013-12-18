package com.xjd.note.biz.service;

import org.springframework.cache.annotation.Cacheable;

import com.xjd.note.biz.component.auth.PreAuthorize;
import com.xjd.note.biz.component.test.TestAnnotation;

/**
 * <pre>
 * 
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:21:11 PM
 */
public interface TestService {

	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param s
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:21:14 PM
	 */
	@Cacheable("test")
	@TestAnnotation("test")
	String testAnnotation(String s);
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param s
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:21:16 PM
	 */
	String testAny(String s);
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:21:19 PM
	 */
	@PreAuthorize("test")
	void testAuth();
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:21:21 PM
	 */
	@PreAuthorize(value="any('test', 'good')", isExpression=true)
	void testAuthAny();
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:21:23 PM
	 */
	@PreAuthorize(value="all('test', 'good')", isExpression=true)
	void testAuthAll();
}
