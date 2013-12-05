<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
	//禁用可恶的IE缓存
    response.setHeader("Pragma","No-cache"); 
    response.setHeader("Cache-Control","no-cache"); 
    response.addDateHeader("Expires", 1L); 
%>
<%
    Integer statusCode = (Integer) request.getAttribute(javax.servlet.RequestDispatcher.ERROR_STATUS_CODE);
    Throwable t = (Throwable) request.getAttribute(javax.servlet.RequestDispatcher.ERROR_EXCEPTION);
    if(t != null) {
        log.error("error", t);
    }
%>
<html>
    <head>
        <title><fmt:message key="page"/><%=statusCode%><fmt:message key="error"/></title>
    </head>
    <body>
   		<h3>
   			<fmt:message key="you_are_not_permitted_to_do_the_operation"/>
   		</h3>
    	<a href="javascript:void(0);" onclick="history.go(-1)"><fmt:message key="go_back"/></a><br/><br/>
    </body>
</html>
<%!
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("AUTHFAIL");
%>