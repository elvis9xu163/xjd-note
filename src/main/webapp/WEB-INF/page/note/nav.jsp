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
		<span class="nav-item-ind glyphicon glyphicon-chevron-down"></span>
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
		<div class="tree-item node">
			<span class="tree-item-ind glyphicon glyphicon-chevron-down"></span>
			<span class="tree-item-icon glyphicon glyphicon-book"></span>
			<span class="tree-item-title">图片</span>
		</div>
		<div class="tree-item-body">
			<div class="tree-item node" style="padding-left: 10px">
				<span class="tree-item-ind glyphicon glyphicon-chevron-right"></span>
				<span class="tree-item-icon glyphicon glyphicon-book"></span>
				<span class="tree-item-title">图片</span>
			</div>
			<div class="tree-item node" style="padding-left: 10px">
				<span class="tree-item-ind glyphicon glyphicon-chevron-down"></span>
				<span class="tree-item-icon glyphicon glyphicon-book"></span>
				<span class="tree-item-title">图片</span>
			</div>
			<div class="tree-item-body">
				<div class="tree-item leaf" style="padding-left: 20px">
					<span class="tree-item-ind glyphicon glyphicon-text-width"></span>
					<span class="tree-item-icon glyphicon glyphicon-file"></span>
					<span class="tree-item-title">图片</span>
				</div>
				<div class="tree-item leaf" style="padding-left: 20px">
					<span class="tree-item-ind glyphicon glyphicon-text-width"></span>
					<span class="tree-item-icon glyphicon glyphicon-file"></span>
					<span class="tree-item-title">图片</span>
				</div>
				<div class="tree-item leaf" style="padding-left: 20px">
					<span class="tree-item-ind glyphicon glyphicon-text-width"></span>
					<span class="tree-item-icon glyphicon glyphicon-file"></span>
					<span class="tree-item-title">图片</span>
				</div>
				<div class="tree-item leaf" style="padding-left: 20px">
					<span class="tree-item-ind glyphicon glyphicon-text-width"></span>
					<span class="tree-item-icon glyphicon glyphicon-file"></span>
					<span class="tree-item-title">图片</span>
				</div>
			</div>
		</div>
	</div>
	<div class="nav-item">
		<span class="nav-item-ind glyphicon glyphicon-chevron-down"></span>
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
	<div class="nav-item-body">
	</div>

	<%-- js --%>
	<jsp:include page="../common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/js/nav.js'/>"></script>
</body>
</html>