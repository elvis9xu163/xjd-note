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
<link href="<c:url value='/assets/ueditor/themes/default/css/ueditor.min.css'/>" rel="stylesheet" media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script type="text/javascript" src="<c:url value='/js/html5shiv.js'/>"></script>
<![endif]-->
</head>
<body>
	
	<div id="editorDiv" style="width:100%; height:100%; overflow: auto; ">
		<script id="editor" type="text/plain" style="width:99%; height:100%;overflow:visible"></script>
	</div>
	
	<!-- Placed at the end of the document so the pages load faster -->
	<jsp:include page="common/js-common.jsp" />
	<script type="text/javascript" src="<c:url value='/assets/ueditor/ueditor.config.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/ueditor/ueditor.all.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/lang/zh-cn/zh-cn.js'/>"></script>
	<script type="text/javascript">
		window.ue = UE.getEditor('editor');
		
		//set editor height
		window.adjustUIHeight = function() {
			ue.setHeight($("body").height() - $("#edui1_toolbarbox").height() - $("#edui1_bottombar").height() - 2);
		}
		
		window.adjustUIWidth = function() {
			var w = $("#editor").width();
			$("#edui1").width(w);
			$("#edui1_iframeholder").width(w - 2);
		}
		
		window.adjustUISize = function() {
			adjustUIWidth();
			adjustUIHeight();
		}
		
		ue.addListener("ready", function() {
			window.parent.eidtorReady = true;
			window.parent.adjustUIHight();
		});
	</script>	
</body>
</html>