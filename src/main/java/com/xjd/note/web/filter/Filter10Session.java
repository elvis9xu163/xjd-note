package com.xjd.note.web.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * <pre>
 * Session相关的Filter注册
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:36:05 PM
 */
@WebFilter(filterName="sessionFilter", urlPatterns="/*",initParams=
{@WebInitParam(name="targetBeanName", value="sessionFilter")
,@WebInitParam(name="targetFilterLifecycle", value="true")
})
public class Filter10Session extends DelegatingFilterProxy {

}
