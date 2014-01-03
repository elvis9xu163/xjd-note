//[[Debug==========================
//var $window = $(window);
//var $body = $("body");
//var $head = $(".head");
//var $content = $(".content");
//var $contentNav = $(".content-nav");
//var $contentBody = $(".content-body");
//var $contentDivider = $(".content-divider");

function debug(msg) {
	$(".debug").html(msg);
}
//==========================Debug]]

//[[拖拽调整大小==========================
var drag = {navMinWidth: 110, bodyMinWidth: 200};
function contentDividerMouseDown(e) {
	$(".content-divider-cover").css("display", "block");
	$(".content-divider").addClass("content-divider-hover");
	drag.x = e.clientX;
	drag.navWidth = $(".content-nav").width();
	drag.bodyWidth = $(".content-body").width();
}

function contentDividerCoverMouseMove(e) {
	drag.dx = e.clientX - drag.x;
	navW = drag.navWidth + drag.dx;
	bodyW = drag.bodyWidth - drag.dx;
	if (navW < drag.navMinWidth) {
		navW = drag.navMinWidth;
	} else if (bodyW < drag.bodyMinWidth) {
		navW -= (drag.bodyMinWidth - bodyW);
	}
	$(".content-nav").width(navW);
	adjustWidth();
	adjustDividerPosition();
}

function contentDividerCoverMouseUp() {
	$(".content-divider-cover").css("display", "none");
	$(".content-divider").removeClass("content-divider-hover");
	//移动过程中的调节是有问题的,此处最后再调节一次
	adjustWidth();
	adjustDividerPosition();
}

//==========================拖拽调整大小]]

//[[UI调整===============================
window.adjustDividerPosition = function() {
	$contentNav = $(".content-nav");
	navOffset = $contentNav.offset();
	navOffset.left += $contentNav.width() + 1;
	$(".content-divider").offset(navOffset);
}

window.adjustHeight = function() {
	contentHeight = $(window).height() - $(".head").height() - 5;
	$(".content").height(contentHeight);
	$(".content-divider").height(contentHeight);
}

window.adjustWidth = function() {
	$(".content-body").width($(window).width() - $(".content-nav").width() - 1);
}

function resize() {
	adjustHeight();
	adjustWidth();
	adjustDividerPosition();
}

//===============================UI调整]]

$(function() {
	$(window).resize(resize);
	$(window).resize();
	
	//拖拽调整大小
	$(".content-divider").mousedown(contentDividerMouseDown);
	$(".content-divider-cover").mousemove(contentDividerCoverMouseMove);
	$(".content-divider-cover").mouseup(contentDividerCoverMouseUp);

});