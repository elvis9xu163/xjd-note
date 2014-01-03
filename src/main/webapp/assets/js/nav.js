//[[nav-item====================
function navItemClick(e) {
	$this = $(this);
	$button = $this.find("button");
	
	if (e.target == $button[0] || $button.find(e.target)[0] != undefined) {
		return; //如果点击的是其中的button
	}
	
	var icon = $(this).find(".nav-item-ind");
	if (icon.hasClass("glyphicon-chevron-right")) {
		icon.removeClass("glyphicon-chevron-right");
		icon.addClass("glyphicon-chevron-down");
		
		$this.next(".nav-item-body").show();
	} else {
		icon.removeClass("glyphicon-chevron-down");
		icon.addClass("glyphicon-chevron-right");
		
		$this.next(".nav-item-body").hide();
	}
}

//====================nav-item]]

//[[tree-item==================
function treeItemDblClick(e) {
	$this = $(this);
	if ($this.hasClass("node")) {
		toggleTreeItem($this);
	} else {
		$(".tree-item").removeClass("tree-item-selected");
		$this.addClass("tree-item-selected");
		//TODO 打开动作
	}
}
function treeItemClick(e) {
	$this = $(this);
	
	if ($this.hasClass("node") && e.target == $this.find(".tree-item-ind")[0]) { //展开或收起
		toggleTreeItem($this);
		
	} else { //选择该节点
		$(".tree-item").removeClass("tree-item-selected");
		$this.addClass("tree-item-selected");
		//TODO 打开动作
	}
}
function toggleTreeItem(item) {
	$this = item;
	$body = $this.next(".tree-item-body");
	if ($body[0] != undefined) {
		$body.toggle();
		if ($body.css("display") == "none") {
			$this.find(".tree-item-ind").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-right");
		} else {
			$this.find(".tree-item-ind").removeClass("glyphicon-chevron-right").addClass("glyphicon-chevron-down");
		}
	}
}
//==================tree-item]]

function initTreeEvent() {
	$(".tree-item").click(treeItemClick);
	$(".tree-item").dblclick(treeItemDblClick);
}

$(function() {
	$(".nav-item").click(navItemClick);
	initTreeEvent();
});