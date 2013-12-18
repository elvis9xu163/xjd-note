<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="display: none">
	<form id="language_select_form" method="post" action="<c:url value='/auth/input'/>">
		<input name="locale" />
		<input name="targetPath" value="${param.targetPath }"/>
		<input name="username" value="${param.username }" />
	</form>
</div>
<div class="navbar navbar-static-top">
	<div class="navbar-inner">
		<a class="brand" href="#"><fmt:message key="xjd_note" /></a>
		<div class="btn-group pull-right">
			<a class="btn btn-success dropdown-toggle" data-toggle="dropdown" href="#"> <fmt:message key="language_select"/> <span class="caret"></span> </a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				<li><a tabindex="-1" href="javascript:changeLanguage('zh_CN');"><img width="32" src='<c:url value="/assets/img/flags/cn_46.png"/>' />中文</a></li>
				<li><a tabindex="-1" href="javascript:changeLanguage('en_US');"><img width="32" src='<c:url value="/assets/img/flags/us_46.png"/>' />English(US)</a></li>
			</ul>
		</div>
	</div>
</div>