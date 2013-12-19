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
<jsp:include page="common/css-common.jsp" />
<link href="<c:url value='/assets/css/main.css'/>" rel="stylesheet" media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script type="text/javascript" src="../js/html5shiv.js"></script>
<![endif]-->
</head>
<body>
	<jsp:include page="common/head-common.jsp" />
	<div class="container">
		<div class="navbar navbar-static-top nav-head">
			<div class="navbar-inner">
				<a class="brand" href="#"><fmt:message key="xjd_note" /></a>
				<form class="navbar-form">
					<div class="input-append">
						<input class="input-large" type="text" placeholder=""/>
						<button type="submit" class="btn">Search</button>
					</div>
				</form>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span3" style="background-color: red">树</div>
			<div class="span9" style="background-color: blue">body</div>
		</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<jsp:include page="common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/js/login.js'/>"></script>
</body>
</html>