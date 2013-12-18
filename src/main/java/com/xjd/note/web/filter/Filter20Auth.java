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
/**
 * <pre>
 * 权限相关的Filter注册
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:36:31 PM
 */
@WebFilter(filterName="authFilter", urlPatterns={"/*"})
public class Filter20Auth extends DelegatingFilterProxy {

}
