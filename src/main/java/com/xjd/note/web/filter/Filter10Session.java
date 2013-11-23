package com.xjd.note.web.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.web.filter.DelegatingFilterProxy;

@WebFilter(filterName="sessionFilter", urlPatterns="/*",initParams=
{@WebInitParam(name="targetBeanName", value="sessionFilter")
,@WebInitParam(name="targetFilterLifecycle", value="true")
})
public class Filter10Session extends DelegatingFilterProxy {

}
