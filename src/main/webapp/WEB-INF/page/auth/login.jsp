<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>欢迎登录XJD Note</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="<c:url value='/assets/ico/favicon.png'/>" />

<!-- css -->
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" media="screen">
<link href="<c:url value='/css/bootstrap-responsive.min.css'/>" rel="stylesheet" media="screen">
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}
.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}
.form-signin .row-fluid:first-child,
.form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin .add-on,
.form-signin input[type="text"],
.form-signin input[type="password"] {
	font-size:16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script type="text/javascript" src="../js/html5shiv.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">
		<form class="form-signin" action="<c:url value='/auth/login'/>" method="post">
			<div class="row-fluid">
				<h2 class="form-signin-heading text-center text-info">
					XJD日志系统
				</h2>
			</div>
			<div class="input-prepend">
				<span class="add-on">用户名:</span>
				<input type="text" name="username" required placeholder="用户名"/>
			</div>
			<div class="input-prepend">
				<span class="add-on">密&nbsp;&nbsp;&nbsp;码:</span>
				<input type="password" name="password" required placeholder="密码"/>
			</div>
			<label class="checkbox muted">
				<input type="checkbox" name="rememberme" value="remember-me"/>记住密码
			</label>
			<input type="hidden" name="targetUrl" value="${param.targetUrl }"/>
			<div class="row-fluid">
				<button class="btn btn-primary btn-large span6 offset3" type="submit">登&nbsp;&nbsp;&nbsp;录</button>
			</div>
		</form>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="<c:url value='/js/jquery-1.9.1.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
</body>
</html>