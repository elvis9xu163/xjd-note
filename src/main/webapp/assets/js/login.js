function changeLanguage(lang) {
	$("#language_select_form input:first-child").val(lang);
	$("#language_select_form input[name='username']").val($("#nameFd").val());
	$("#language_select_form input[name='password']").val($("#passFd").val());
	$("#language_select_form").submit();
}

$(function() {
	$("#registerBtn").click(function() {
		alert("暂不开放注册！");
		return false;
	});
	
	$("#findPassLink").click(function() {
		alert("暂不支持该功能！");
		return false;
	});
	$(":checkbox[name='rememberme']").click(function() {
		alert("暂不支持该功能！");
		return false;
	});
});