<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- js --%>
<jsp:include page="../common/js-common.jsp" />
<script type="text/javascript">
var result = ${result };
if (window.parent) {
	window.parent.saveNoteResult(result);
}
</script>
