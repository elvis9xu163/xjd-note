<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="navbar navbar-static-top nav-top">
	<div class="navbar-inner">
		
		<div class="btn-group pull-right">
			<a class="btn btn-mini btn-success disabled">
				<i class="fa fa-user"></i>
				<span>${requestScope.username }</span>
			</a>
			<a class="btn btn-mini btn-success dropdown-toggle" data-toggle="dropdown" href="#">
				<span class="fa fa-angle-down"></span>
			</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				<li><a tabindex="-1" href="javascript:changeLanguage('zh_CN');">
					<i class="fa fa-cogs margin-right-fw"></i><fmt:message key="settings" />
				</a></li>
				<li class="divider"></li>
				<li><a tabindex="-1" href="javascript:changeLanguage('en_US');">
					<i class="fa fa-sign-out margin-right-fw"></i><fmt:message key="quit" />
				</a></li>
			</ul>
		</div>
	</div>
</div>