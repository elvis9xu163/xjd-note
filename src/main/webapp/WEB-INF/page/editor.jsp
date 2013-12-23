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
<style type="text/css">
	.edui-default .edui-editor {
		border: 0px !important;
	}
	#edui1 {
		background-color: transparent;
	}
	#edui1_toolbarboxouter {
		border-left: 0px;
		border-radius: 0;
	}
	#edui1_iframeholder {
		background-color: #fff;
		border: 1px solid #D1D2D4;
		margin: 20px;
		width: 80%;
	}
</style>
</head>
<body style="background-color: #F3F5F7">
	
	<div id="editorDiv" style="height:100%; overflow:hidden; ">
		<script id="editor" type="text/plain" style="width:100%; height:100%;"></script>
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
			var h = $("body").height() - $("#edui1_toolbarbox").height() - $("#edui1_bottombar").height();
			/* ue.setHeight(h);
			$("#ueditor_0").contents().find("body").height(h);
			if ($("#ueditor_0").contents().find("body")[0].scrollHeight > h) {
				$("#ueditor_0").contents().find("body").css("overflow-y","visible");
			} else {
				$("#ueditor_0").contents().find("body").css("overflow-y","hidden");
			}
			alert($("#ueditor_0").contents().find("body")[0].scrollHeight + "," + h); */
		}
		
		window.adjustUIWidth = function() {
			var w = $("#editor").width();
			$("#edui1").width(w);
			$("#edui1_iframeholder").width(w - 40);
		}
		
		window.adjustUISize = function() {
			adjustUIWidth();
			adjustUIHeight();
		}
		
		ue.addListener("ready", function() {
		
			window.parent.eidtorReady = true;
			window.parent.adjustUIHight();
			//$("#ueditor_0").contents().find("body").css("overflow-y","hidden");
			$($("#ueditor_0")[0].contentWindow).resize(function(e) {
				//$("#ueditor_0").contents().find("body").height(h);
				//alert(this.parent.document);
				//alert($("#edui1_iframeholder", this.parent.document).height() + "," + h);
				//$("#edui1_iframeholder", this.parent.document).height($("#editor", this.parent.document).height());
				this.parent.adjustUIHeight();
				//alert(h + "," + $("#ueditor_0").contents().find("body").height());
			});
			//test
			/* alert("HELLO");
			ue.setOpt({toolbars:[['undo']]});
			ue.render(ue);
			alert("HELLO2"); */
		});
	</script>	
</body>
</html>