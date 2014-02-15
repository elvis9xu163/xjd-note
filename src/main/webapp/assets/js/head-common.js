$(function() {
	$("#settingLink").click(function() {
		alert("暂不支持该功能！");
		return false;
	});

	$("#exitLink").click(function() {
		$.post(quitUrl, function(data) {
			window.location.reload(true);
		});
	});
});
