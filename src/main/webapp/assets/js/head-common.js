function doLogout() {
	$.post(quitUrl, function(data) {
		window.location.reload(true);
	});
}