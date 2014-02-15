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
	<div class="for-template">
		<div class="tree-item node" inited="false">
			<span class="tree-item-ind glyphicon glyphicon-chevron-right"></span>
			<span class="tree-item-icon glyphicon glyphicon-book"></span>
			<span class="tree-item-title"></span>
		</div>
		<div class="tree-item leaf">
			<span class="tree-item-ind glyphicon glyphicon-text-width"></span>
			<span class="tree-item-icon glyphicon glyphicon-file"></span>
			<span class="tree-item-title"></span>
		</div>
		<div class="tree-item-body" style="display:none"></div>
	</div>
	<div class="nav-item" id="notebook">
		<span class="nav-item-ind glyphicon glyphicon-chevron-down"></span>
		<span class="nav-item-title">笔记本</span>
		<div class="btn-group pull-right nav-item-oper">
		  <button type="button" class="btn btn-default btn-xs btn-xxs dropdown-toggle" data-toggle="dropdown">
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="javascript:newNote(true)">新建笔记本</a></li>
		    <li><a href="javascript:newNote(false)">新建笔记</a></li>
		    <li><a href="javascript:renameNote()">重命名</a></li>
		    <li class="divider"></li>
		    <li><a href="javascript:deleteNote()">删除</a></li>
		  </ul>
		</div>
	</div>
	<div class="nav-item-body">
		<!-- <div class="tree-item node" id="1">
			<span class="tree-item-ind glyphicon glyphicon-chevron-down"></span>
			<span class="tree-item-icon glyphicon glyphicon-book"></span>
			<span class="tree-item-title">图片</span>
		</div>
		<div class="tree-item-body" level="1">
			<div class="tree-item node"  id="1" style="padding-left: 10px">
				<span class="tree-item-ind glyphicon glyphicon-chevron-right"></span>
				<span class="tree-item-icon glyphicon glyphicon-book"></span>
				<span class="tree-item-title">图片</span>
			</div>
			<div class="tree-item node" id="1" style="padding-left: 10px">
				<span class="tree-item-ind glyphicon glyphicon-chevron-down"></span>
				<span class="tree-item-icon glyphicon glyphicon-book"></span>
				<span class="tree-item-title">图片</span>
			</div>
			<div class="tree-item-body"  level="2">
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
		</div> -->
	</div>
	<div class="nav-item">
		<span class="nav-item-ind glyphicon glyphicon-chevron-down"></span>
		<span class="nav-item-title">回收站</span>
		<div class="btn-group pull-right nav-item-oper">
		  <button type="button" class="btn btn-default btn-xs btn-xxs dropdown-toggle" data-toggle="dropdown">
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="#">还原笔记</a></li>
		    <li class="divider"></li>
		    <li><a href="#">清空回收站</a></li>
		    <li><a href="#">删除</a></li>
		  </ul>
		</div>
	</div>
	<div class="nav-item-body">
	</div>

	<%-- js --%>
	<jsp:include page="../common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/js/nav.js'/>"></script>
	<script type="text/javascript">
		var listNotesUrl = "<c:url value='/note/listNodes'/>";
		var newNoteUrl = "<c:url value='/note/newNote'/>";
		var noteBodyUrl = "<c:url value='/note/body'/>";
		var noteRenameUrl = "<c:url value='/note/rename'/>";
		var noteDeleteUrl = "<c:url value='/note/delete'/>";
	</script>
</body>
</html>