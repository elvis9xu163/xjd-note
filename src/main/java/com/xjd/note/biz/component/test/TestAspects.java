package com.xjd.note.biz.component.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TestAspects {
	private static final Logger log = LoggerFactory.getLogger(TestAspects.class);
	
	@Pointcut("@annotation(com.xjd.note.biz.component.test.TestAnnotation)")
	public void testAnnotation(){};
	
	@Pointcut("execution(* com.xjd.note.biz.service.TestService.*(..))")
	public void testAnnotation2(){};
	
	@Before(value="testAnnotation() && @annotation(anno)")
	public void beforeTestAnnotation(TestAnnotation anno) {
		log.debug("called!");
		log.debug("Annotation is : " + anno + ": " + anno.value());
	}
	
	@Before("testAnnotation2()")
	public void beforeAnyMethods(JoinPoint joinpoint) {
		log.debug("called!");
		
//		System.out.println(joinpoint);
//		System.out.println(joinpoint.getThis());
//		System.out.println(joinpoint.getTarget());
//		System.out.println(Arrays.toString(joinpoint.getArgs()));
//		System.out.println(joinpoint.getSignature());
//		System.out.println(joinpoint.getSourceLocation());
//		System.out.println(joinpoint.getKind());
//		System.out.println(joinpoint.getStaticPart());
		
		if (joinpoint.getSignature() instanceof MethodSignature) {
			Method method = ((MethodSignature) joinpoint.getSignature()).getMethod();
			System.out.println(method);
			Annotation[] anns = method.getAnnotations();
			for (Annotation ann : anns) {
				System.out.println(ann);
			}
		}
	}
}
