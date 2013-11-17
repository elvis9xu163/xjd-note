package com.xjd.note.biz.component;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TestAspects {
	@Pointcut("@annotation(com.xjd.note.biz.component.TestAnnotation)")
	public void testAnnotation(){};
	
	@Pointcut("execution(* com.xjd.note.biz.service.*.*(..))")
	public void testAnnotation2(){};
	
	@Before(value="testAnnotation() && @annotation(anno)")
	public void beforeTestAnnotation(TestAnnotation anno) {
		System.out.println("TestAnnotation aspect execute!");
		System.out.println("Annotation is : " + anno + ": " + anno.value());
	}
}
