package com.xjd.note.biz.component.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 授权注解
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:05:25 PM
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PreAuthorize {
	String value();
	boolean isExpression() default false;
}
