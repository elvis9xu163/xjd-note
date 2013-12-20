$(function() {
	//=============UI==============
	//自适应高度
	function adjustUIHight() {
		var mainbodyhight = $(window).height() - $(".nav-head").height() - $(".nav-top").height() - $(".nav-footer").height();
		$(".main-body").height(mainbodyhight);
		$(".main-body .v-divider").height(mainbodyhight);
		$(".main-body .v-divider i").css("margin-top", mainbodyhight/2 - 5);
		$(".main-body .body-tree").height(mainbodyhight);
		$(".main-body .body-body").height(mainbodyhight);
		$(".ztree").height(mainbodyhight - 10);
		$("iframe").height(mainbodyhight);
		$("iframe").contents().find("body").height(mainbodyhight);
		alert($("iframe").contents().find("body"));
//		$("#editor").height(mainbodyhight);
	}
	//自适应宽度
	function adjustUIWidth() {
		$(".main-body .body-body").width($(".main-body").width() - $(".main-body .v-divider").width() - $(".main-body .body-tree").width() - 25);
	}
	
	//window resize事件
	$(window).resize(function() {
		adjustUIHight();
		adjustUIWidth();
	});
	$(window).resize();
	
	//可调节宽度
	var defaultWidth = $(".main-body .body-tree").width();
	var draging = false;
	var leftDiff = 0;
	var offsetX = 0;
	var oldWidth = 0;
	var dragDiv = $("<div id='dragCover'/>");
	dragDiv.css("position", "absolute");
	dragDiv.css("z-index", "999");
	dragDiv.css("width", "100%");
	dragDiv.css("height", "100%");
	dragDiv.css("left", "0px");
	dragDiv.css("top", "0px");
	dragDiv.css("cursor", "e-resize");
	dragDiv.mousemove(doDraging);
	function doDraging(e){
		if (draging) {
			x = e.pageX;
			var dragRange = {min:5, max:$(window).width() - 35}
			if (x < dragRange.min) {
				x = dragRange.min;
			} else if (x > dragRange.max) {
				x = dragRange.max;
			}
			$(".main-body .v-divider").offset({left: x - leftDiff});
			$(".main-body .body-tree").width(oldWidth + (x - offsetX));
			$(".main-body .v-divider").css("position", "static");
			if (x == dragRange.min && $(".main-body .v-divider i").hasClass("fa-angle-left")) {
				$(".main-body .v-divider i").removeClass("fa-angle-left");
				$(".main-body .v-divider i").addClass("fa-angle-right");
			} else if ($(".main-body .v-divider i").hasClass("fa-angle-right")) {
				$(".main-body .v-divider i").removeClass("fa-angle-right");
				$(".main-body .v-divider i").addClass("fa-angle-left");
			}
			adjustUIWidth();
			$("#debug").text(e.pageX + ", " + e.pageY + ", " + x);
		}
	}
	dragDiv.mouseup(function(e){
		draging = false;
		dragDiv.detach();
		$("#debug").text(e.pageX + ", " + e.pageY);
	});
	$(".main-body .v-divider").mousedown(function(e) {
		draging = true;
		defaultWidth = $(".main-body .body-tree").width();
		offsetX = e.pageX;
		leftDiff = e.pageX - $(this).offset().left;
		oldWidth = $(".main-body .body-tree").width();
		dragDiv.appendTo($("body"));
		$("#debug").text($(this).offset().left + ", " + e.pageX + ", " + e.pageY);
	});
	
	//快速宽度
	$(".main-body .v-divider i").mousedown(function() {
		return false;
	});
	$(".main-body .v-divider i").mouseup(function() {
		return false;
	});
	$(".main-body .v-divider i").click(function() {
		$this = $(this);
		if ($this.hasClass("fa-angle-left")) {
			defaultWidth = $(".main-body .body-tree").width()
			e = {pageX:0, pageY:0};
		} else {
			e = {pageX:defaultWidth, pageY:0};
			leftDiff = 0;
			offsetX = 0;
			oldWidth = 0;
		}
		draging = true;
		doDraging(e);
		draging = false;
	});
	
	//=============Tree============
	var zTree;
	var demoIframe;
	var setting = {
		view: {
			dblClickExpand: false,
			showLine: false,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src",treeNode.file + ".html");
					return true;
				}
			}
		}
	};
	
	var t = $("#tree");
	t = $.fn.zTree.init(t, setting, zNodes);
//		var zTree = $.fn.zTree.getZTreeObj("tree");
//		zTree.selectNode(zTree.getNodeByParam("id", 101));

	//=============Editor=============
	//实例化编辑器
//    var ue = UE.getEditor('editor');
});
