package com.xjd.note.biz.component;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Inherited
@Retention (RUNTIME)
@Target(METHOD)
@Documented
public @interface TestAnnotation {
	String value();
}