

$(function() {
	$(".nav-item").click(function(e) {
		$this = $(this);
		$button = $this.find("button");
		
		if (e.target == $button[0] || $button.find(e.target)[0] != undefined) {
			return;
		}
		
		var icon = $(this).find(".nav-item-icon");
		if (icon.hasClass("caret-down")) {
			icon.removeClass("caret-down");
			icon.addClass("caret-right");
		} else {
			icon.removeClass("caret-right");
			icon.addClass("caret-down");
		}
	});
	
});