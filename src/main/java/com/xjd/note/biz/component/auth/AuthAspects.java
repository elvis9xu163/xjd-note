package com.xjd.note.biz.component.auth;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class AuthAspects {

	@Pointcut("execution(* com.xjd.note.biz.service.*.*(..))")
	public void authPointcut(){}
	
	@Before("authPointcut()")
	public void before(JoinPoint jp) {
		if (jp.getSignature() instanceof MethodSignature) {
			PreAuthorize anno = ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(PreAuthorize.class);
			if (anno != null) {
				//TODO
			}
		}
	}
}
