<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title><fmt:message key="welcome_to_xjd_note"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="<c:url value='/assets/img/logo-32.png'/>" />
	
	<%-- css --%>
	<jsp:include page="../common/css-common.jsp" />
	<link rel="stylesheet" href="<c:url value='/assets/css/head.css'/>">
	<link rel="stylesheet" href="<c:url value='/assets/css/main.css'/>">
</head>
<body>
	<%-- head --%>
	<jsp:include page="head.jsp" />
	<div class="content">
		<div class="content-item content-nav">
			<iframe id="nav" src="<c:url value='/note/nav'/>"></iframe>
		</div>
		<div class="content-item content-body">
			<iframe id="body" src="<c:url value='/note/body?isNoteBook=false'/>"></iframe>
		</div>
	</div>
	<div class="content-divider"></div>
	<div class="content-divider-cover"></div>
	<div class="debug"></div>
	<%-- js --%>
	<jsp:include page="../common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/js/main.js'/>"></script>
</body>
</html>