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
<link href="<c:url value='/assets/zTreeStyle/zTreeStyle.css'/>" rel="stylesheet" media="screen">
<%-- <link href="<c:url value='/assets/ueditor/themes/default/css/ueditor.min.css'/>" rel="stylesheet" media="screen"> --%>
<link href="<c:url value='/assets/css/main.css'/>" rel="stylesheet" media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script type="text/javascript" src="<c:url value='/js/html5shiv.js'/>"></script>
<![endif]-->
</head>
<body>
	<jsp:include page="common/head-common.jsp" />
	<div class="container">
		<div class="navbar navbar-static-top nav-head">
			<div class="navbar-inner">
				<a class="brand" href="#"><fmt:message key="xjd_note" /></a>
				<ul class="nav">
					<li class="divider-vertical"></li>
				</ul>
				<form class="navbar-form">
					<div class="input-append">
						<input class="input-large" type="text" placeholder='<fmt:message key="keywords"/>'/>
						<button type="submit" class="btn"><i class="fa fa-search"></i></button>
					</div>
				</form>
			</div>
		</div>
		<div class="row-fluid main-body">
			<div class="span3 body-tree">
				<ul id="tree" class="ztree" style="overflow: auto;"></ul>
			</div>
			<div class="v-divider">
				<i class="fa fa-angle-left"></i>
			</div>
			<div class="span9 body-body">
				<iframe id="testIframe" name="testIframe" src="<c:url value='/editor'/>"></iframe>
				<!-- <script id="editor" type="text/plain" style="width:100%;height:100%;overflow:auto;"></script> -->
			</div>
		</div>
		<div class="navbar nav-footer navbar-static-top">
			<div class="navbar-inner">
			</div>
		</div>
	</div>
	<div id="debug" style="display: none; position: absolute; left: 10px; top: 10px; width: 100px; height: 20px; z-index: 100">
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<jsp:include page="common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/zTreeStyle/jquery.ztree.core-3.5.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/ueditor/ueditor.config.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/ueditor/ueditor.all.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/lang/zh-cn/zh-cn.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/head.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/json-data.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/main.js'/>"></script>
</body>
</html>