package com.xjd.note.biz.component.auth;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.xjd.note.biz.exception.AuthExceptionType;
import com.xjd.note.biz.exception.AuthRuntimeException;

@Component
@Aspect
@Order(10)
public class AuthAspects {
	private static final Logger log = LoggerFactory.getLogger(AuthAspects.class);
	
	@Autowired
	AuthDecider authDecider;
	
	ExpressionParser parser;
	
	EvaluationContext evaluationContext;
	
	@PostConstruct
	public void init() {
		parser = new SpelExpressionParser();
		evaluationContext = new StandardEvaluationContext(authDecider);
	}

	@Pointcut("execution(* com.xjd.note.biz.service.*.*(..))")
	public void authPointcut(){}
	
	@Before("authPointcut()")
	public void before(JoinPoint jp) {
		if (jp.getSignature() instanceof MethodSignature) {
			Method method = ((MethodSignature) jp.getSignature()).getMethod();
			if (log.isTraceEnabled()) {
				log.trace(method.toString());
			}
			PreAuthorize anno = method.getAnnotation(PreAuthorize.class);
			if (anno != null) {
				if (log.isTraceEnabled()) {
					log.trace("Need auth: " + anno);
				}
				if (StringUtils.isBlank(anno.value())) {
					if (anno.isExpression()) {
						throw new AuthRuntimeException(AuthExceptionType.NO_AUTH_EXPRESSION_SET);
					} else {
						throw new AuthRuntimeException(AuthExceptionType.NO_AUTHORITY_SET);
					}
				}
				if (anno.isExpression()) {
					//是表达式
					Expression exp = parser.parseExpression(anno.value());
					boolean rt = exp.getValue(evaluationContext, Boolean.class);
					if (log.isTraceEnabled()) {
						log.trace("Auth result: " + rt);
					}
					if (!rt) {
						throw new AuthRuntimeException(AuthExceptionType.NOT_SATISFY_AUTH_EXPRESSION, anno.value());
					}
				} else {
					//非表达式
					String[] auths = anno.value().split("[,\\s]+");
					StringBuilder sb = new StringBuilder("(");
					for (int i = 0; i < auths.length; i++) {
						sb.append("'" + auths[i].trim() + "',");
					}
					sb.setCharAt(sb.length() - 1, ')');
					sb.insert(0, "all");
					if (log.isTraceEnabled()) {
						log.trace("auth expression: " + sb.toString());
					}
					Expression exp = parser.parseExpression(sb.toString());
					boolean rt = exp.getValue(evaluationContext, Boolean.class);
					if (log.isTraceEnabled()) {
						log.trace("Auth result: " + rt);
					}
					if (!rt) {
						throw new AuthRuntimeException(AuthExceptionType.NOT_HAS_AUTHORITY, anno.value());
					}
				}
			} else {
				if (log.isTraceEnabled()) {
					log.trace("No need auth.");
				}
			}
		}
	}
}
