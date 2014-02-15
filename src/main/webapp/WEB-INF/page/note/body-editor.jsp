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
	<link rel="stylesheet" href="<c:url value='/assets/css/body-editor.css'/>">
</head>
<body>
	<div id="editorDiv" style="overflow:hidden; padding: 0px 20px; display: none;">
		<form action="<c:url value='/note/saveNote'/>" target="forSubmit" method="post">
			<script id="editor" name="editorContent" type="text/plain" style="width:100%; height:100%;"></script>
			<input type="hidden" name="id" value="">
			<button id="btnSave" type="button" class="btn btn-primary">保存</button>
		</form>
	</div>
	<div style="display:none">
		<iframe name="forSubmit"></iframe>
		<div id="saveSuccessTemplate" class="edui-box edui-button edui-default" style="display:none !important; color:green;">
			<span class="glyphicon glyphicon-ok"></span> 保存成功
		</div>
		<div id="saveFailTemplate" class="edui-box edui-button edui-default" style="display:none !important; color:red;">
			<span class="glyphicon glyphicon-remove"></span> 保存失败
		</div>
	</div>

	<%-- js --%>
	<jsp:include page="../common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/ueditor/ueditor.config.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/ueditor/ueditor.all.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/lang/zh-cn/zh-cn.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/body-editor.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/debug.js'/>"></script>
	<script type="text/javascript">
		var readNoteUrl = "<c:url value='/note/readNote'/>";
	</script>
</body>
</html>