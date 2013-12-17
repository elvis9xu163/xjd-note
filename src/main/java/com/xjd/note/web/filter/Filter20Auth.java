package com.xjd.note.web.filter;

import javax.servlet.annotation.WebFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

/*@WebFilter(filterName="authFilter", urlPatterns={"/*"}, initParams=
{@WebInitParam(name="targetBeanName", value="authFilter")
,@WebInitParam(name="targetFilterLifecycle", value="true")
,@WebInitParam(name="ignoreUrlPattern", value="/auth/**, /css/**, /img/**, /js/**")
,@WebInitParam(name="authCookieName", value="xjd.note.auth")
,@WebInitParam(name="authFailUrl", value="/auth/login/input")
,@WebInitParam(name="authVarName", value="user")})*/
@WebFilter(filterName="authFilter", urlPatterns={"/*"})
public class Filter20Auth extends DelegatingFilterProxy {

}
