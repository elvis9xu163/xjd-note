<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="navbar navbar-static-top">
	<div class="navbar-inner">
		<a class="brand" href="#"><fmt:message key="xjd_note" /></a>
		<div class="btn-group pull-right">
			<a class="btn btn-success disabled">
				<i class="icon-user"></i>
				<span>${requestScope.username }</span>
			</a>
			<a class="btn btn-success dropdown-toggle" data-toggle="dropdown" href="#">
				<span class="caret"></span>
			</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				<li><a tabindex="-1" href="javascript:changeLanguage('zh_CN');">
					<i class="icon-asterisk"></i><fmt:message key="xjd_note" />
				</a></li>
				<li><a tabindex="-1" href="javascript:changeLanguage('en_US');">
					<i class="icon-trash"></i><fmt:message key="xjd_note" />
				</a></li>
			</ul>
		</div>
	</div>
</div>