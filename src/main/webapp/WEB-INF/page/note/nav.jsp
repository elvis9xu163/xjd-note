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
	<link rel="stylesheet" href="<c:url value='/assets/css/nav.css'/>">
</head>
<body>
	<div class="nav-item">
		<span class="nav-item-icon caret-right"></span>
		<span class="nav-item-title">笔记本</span>
		<div class="btn-group pull-right nav-item-oper">
		  <button type="button" class="btn btn-default btn-xs btn-xxs dropdown-toggle" data-toggle="dropdown">
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="#">新建笔记本</a></li>
		    <li><a href="#">新建笔记</a></li>
		    <li><a href="#">重命名</a></li>
		    <li class="divider"></li>
		    <li><a href="#">删除</a></li>
		  </ul>
		</div>
	</div>
	<div class="nav-item-body">
		<div class="dir">
			<span class="dir-ind caret-down"></span>
			<span class="dir-icon glyphicon glyphicon-book"></span>
			<span class="dir-title">图片</span>
			<div class="btn-group pull-right dir-oper">
			  <button type="button" class="btn btn-default btn-xs btn-xxs dropdown-toggle" data-toggle="dropdown">
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a href="#">新建笔记本</a></li>
			    <li><a href="#">新建笔记</a></li>
			    <li><a href="#">重命名</a></li>
			    <li class="divider"></li>
			    <li><a href="#">删除</a></li>
			  </ul>
			</div>
		</div>
		<div class="dir-body">
			<div class="dir" style="padding-left: 15px">
				<i class="dir-ind caret-right"></i>
				<span class="dir-icon glyphicon glyphicon-book"></span>
				<span class="dir-title">美女</span>
			</div>
			<div class="dir" style="padding-left: 15px">
				<i class="dir-ind caret-down"></i>
				<span class="glyphicon glyphicon-book"></span>
				<span>美女</span>
			</div>
			<div class="dir-body">
				<div class="file" style="padding-left: 30px"><span class="glyphicon glyphicon-file"></span> 图片1</div>
				<div class="file" style="padding-left: 30px"><span class="glyphicon glyphicon-file"></span> 图片1</div>
				<div class="file" style="padding-left: 30px"><span class="glyphicon glyphicon-file"></span> 图片1</div>
			</div>
			<div class="dir" style="padding-left: 15px">
				<i class="dir-ind fa fa-angle-down fa-fw"></i>
				<span class="dir-icon glyphicon glyphicon-book"></span>
				<span class="dir-title">美女</span>
			</div>
			<div class="dir" style="padding-left: 15px">
				<i class="fa fa-angle-right fa-fw"></i>
				<span class="glyphicon glyphicon-book"></span>
				<span>美女</span>
			</div>
		</div>
	</div>
	<div class="nav-item">
		<span class="nav-item-icon caret-right"></span>
		<span class="nav-item-title">标签</span>
		<div class="btn-group pull-right nav-item-oper">
		  <button type="button" class="btn btn-default btn-xs btn-xxs dropdown-toggle" data-toggle="dropdown">
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="#">新建笔记本</a></li>
		    <li><a href="#">新建笔记</a></li>
		    <li><a href="#">重命名</a></li>
		    <li class="divider"></li>
		    <li><a href="#">删除</a></li>
		  </ul>
		</div>
	</div>
	<!-- <div class="nav-item-body">
		hello
	</div> -->

	<%-- js --%>
	<jsp:include page="../common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/js/nav.js'/>"></script>
</body>
</html>