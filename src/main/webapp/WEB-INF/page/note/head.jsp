<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="navbar head navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">XJD Note System</a>
	</div>
	<div class="collapse navbar-collapse">
		<ul class="nav navbar-nav pull-right">
			<li>
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<span class="glyphicon glyphicon-user"></span> elvis9xu@163.com <span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a id="settingLink" href="#">设置</a></li>
					<li class="divider"></li>
					<li><a id="exitLink" href="#">退出</a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>

<script type="text/javascript">
	var quitUrl = '<c:url value="/auth/logout"/>';
</script>
	
