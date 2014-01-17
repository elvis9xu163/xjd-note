<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="welcome_to_xjd_note"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="<c:url value='/assets/ico/logo-32.png'/>" />

<!-- css -->
<jsp:include page="../common/css-common.jsp" />
<link href="<c:url value='/assets/css/login.css'/>" rel="stylesheet" media="screen">
<style>

</style>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script type="text/javascript" src="../js/html5shiv.js"></script>
<![endif]-->
</head>
<body>
	<div style="display: none">
		<form id="language_select_form" method="post" action="<c:url value='/auth/input'/>">
			<input name="locale" />
			<input name="targetPath" value="${param.targetPath }"/>
			<input name="username" value="${param.username }" />
		</form>
	</div>
	<div class="navbar navbar-static-top head">
		<div class="navbar-inner">
			<a class="brand" href="#"><fmt:message key="xjd_note" /></a>
			<div class="input-group pull-right">
				<a class="btn btn-success dropdown-toggle" data-toggle="dropdown" href="#"> <fmt:message key="language_select"/> <span class="caret"></span> </a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
					<li><a tabindex="-1" href="javascript:changeLanguage('zh_CN');"><img width="32" src='<c:url value="/assets/img/flags/cn_46.png"/>' />中文</a></li>
					<li><a tabindex="-1" href="javascript:changeLanguage('en_US');"><img width="32" src='<c:url value="/assets/img/flags/us_46.png"/>' />English(US)</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="wrapper">
			<div class="main">
				<div style="font-size: 26px;">
					<c:if test="${param.targetPath == null || param.targetPath == ''}">
						<fmt:message key="welcome_back"/>
					</c:if>
					<c:if test="${param.targetPath != null && param.targetPath != ''}">
						<fmt:message key="please_login_first"/>
					</c:if>
				</div>
				<hr/>
				<div class="row">
					<div class="col-md-6">
						<div style="width: 100%; padding-top: 150px; font-size: 26px; color: gray;">
							<fmt:message key="advertisement"/>
						</div>
					</div>
					<div class="col-md-6 form-wrapper" style="background-color: rgb(245, 245, 245);">
						<form action="<c:url value='/auth/login'/>" method="post">
							<div class="row">
								<div id="login-div" class="col-md-10 col-md-offset-1">
									<c:if test="${requestScope.errorMsg != null}">
									<div>
										<h5 class="form-signin-heading text-center text-error">
											${requestScope.errorMsg}
										</h5>
									</div>
									</c:if>
									<div class="row">
										<div class="input-group">
											<input class="form-control" type="text" name="username" required placeholder='<fmt:message key="username_or_mail"/>' value="${param.username }"/>
											<span class="input-group-addon"><fmt:message key="account"/></span>
										</div>
										<div class="input-group">
											<input class="form-control" type="password" name="password" required placeholder='<fmt:message key="password"/>'/>
											<span class="input-group-addon"><fmt:message key="password"/></span>
										</div>
									</div>
									<div class="row">
										<div class="checkbox muted">
											<input type="checkbox" name="rememberme" value="remember-me"/><fmt:message key="remember_me_one_week"/>
											<span class="pull-right">
												<a href=""><fmt:message key="forget_password"/></a>
											</span>
										</div>
									</div>
									<div class="row">
										<button class="btn btn-success btn-large col-md-5" type="submit"><i class="fa fa-sign-in"></i><fmt:message key="login"/></button>
										<button class="btn btn-info btn-large col-md-5 col-md-offset-2"><i class="fa fa-pencil-square-o"></i><fmt:message key="register"/></button>
									</div>
								</div>
							</div>
							<input type="hidden" name="targetPath" value="${param.targetPath }"/>
						</form>
					</div>
				</div>
			</div>
			<div class="shadow">
			</div>
			<div class="footer">
				<a target="_blank" class="footer-entry" href=""><fmt:message key="service_terms"/></a>
				<a target="_blank" class="footer-entry" href=""><fmt:message key="privacy_statement"/></a>
				<span class="footer-entry last">
    				<fmt:message key="copyright_announcement"/>
    			</span>
			</div>
		</div>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<jsp:include page="../common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/js/login.js'/>"></script>
</body>
</html>