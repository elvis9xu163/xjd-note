//[[common======================
function  selectItem($item) {
	$(".tree-item").removeClass("tree-item-selected");
	$item.addClass("tree-item-selected");
	var id = $item.attr("nid");
	var isNoteBook = $item.hasClass("node");
	
	$("#body", window.parent.document)[0].contentWindow.openNote(id, isNoteBook);
	//$("#body", window.parent.document).attr("src", noteBodyUrl + "?" + $.param({id: id, isNoteBook: isNoteBook}));
}

function getSelectedItem() {
	$selectedItem = $(".tree-item-selected");
	if ($selectedItem[0]) {
		return $selectedItem;
	}
	return null;
}

function getSelectedNode() {
	$selectedItem = getSelectedItem();
	if ($selectedItem) {
		if ($selectedItem.hasClass("node")) {
			return $selectedItem;
		} else {
			$parent = $selectedItem.parent();
			if ($parent[0] && $parent.hasClass("tree-item-body")) {
				return $parent.prev();
			}
		}
	}
	return null;
}

function setAttributes($item, level, data) {
	$item.attr("nid", data.id);
	$item.attr("level", level * 1 + 1);
	$item.css("padding-left", level * padding + "px");
	$item.find(".tree-item-title").html(data.name);
}

//======================common]]

//[[nav-item-oper===============
function newNote(isNoteBook) {
	var msg = "请输入笔记名！";
	var defaultVal = "新笔记";
	if (isNoteBook) {
		msg = "请输入目录名！";
		defaultVal = "新目录";
	}
	var val = prompt(msg, defaultVal);
	var $selectedNode = getSelectedNode();
	var id = "";
	if ($selectedNode) {
		id = $selectedNode.attr("nid");
	}
	var param = $.param({"id": id, "value": val, "isNoteBook": isNoteBook});
	$.post(newNoteUrl + "?" + param, function(data) {
		var $selectedNode = getSelectedNode();
		var $selectedNodeBody;
		var level = 0;
		if (!$selectedNode) {
			$selectedNodeBody = $("#notebook").next();
		} else {
			level = $selectedNode.attr("level");
			$selectedNodeBody = $selectedNode.next();
		}
		var $item;
		var $itemBody = null;
		if (isNoteBook) {
			$item = $(".for-template .node").clone(true, true);
			$itemBody = $(".for-template .tree-item-body").clone(true, true);
		} else {
			$item = $(".for-template .leaf").clone(true, true);
		}
		setAttributes($item, level, data);
		$selectedNodeBody.append($item);
		if ($itemBody) {
			$selectedNodeBody.append($itemBody);
		}
		selectItem($item);
	});
}

function selectedNode() {
	$selectedItem = $(".tree-item-selected");
	if ($selectedItem[0]) {
		if ($selectedItem.hasClass("node")) {
			return $selectedItem;
		} else {
			$selectedNodeBody = $selectedItem.parent();
			if ($selectedNodeBody[0]) {
				if ($selectedNodeBody.hasClass("tree-item-body")) {
					return $selectedNodeBody.prev();
				}
			}
		}
	}
	return null;
}

//===============nav-item-oper]]
//[[nav-item====================
function navItemClick(e) {
	$this = $(this);
	$oper = $this.find(".nav-item-oper");
	
	if (e.target == $oper[0] || $oper.find(e.target)[0] != undefined) {
		return; //如果点击的是其中的opern部分
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
		selectItem($this)
		//TODO 打开动作
	}
}
function treeItemClick(e) {
	$this = $(this);
	
	if ($this.hasClass("node") && e.target == $this.find(".tree-item-ind")[0]) { //展开或收起
		toggleTreeItem($this);
		
	} else { //选择该节点
		selectItem($this)
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
			if ($this.attr("inited") == "false") {
				loadChildrenFor($this, $body);
			}
		}
	}
}
//==================tree-item]]

//[[load data==================
var padding = 15;
function loadNotes() {
	loadChildrenFor(null, $("#notebook").next());
}
function loadChildrenFor(node, body) {
	param = "";
	level = 0;
	if (node) {
		param = $.param({"id": node.attr("nid")});
		level = node.attr("level");
	}
	$.getJSON(listNotesUrl + "?" + param, function(data) {
		if (data) {
			$nodeItem = $(".for-template .node");
			$leafItem = $(".for-template .leaf");
			$itemBody = $(".for-template .tree-item-body");
			body.html("");
			for (var i=0; i<data.length; i++) {
				dat = data[i];
				var $item = null;
				var $body = null;
				if (dat.isParent) {
					$item = $nodeItem.clone(true, true);
					$body = $itemBody.clone(true, true);
				} else {
					$item = $leafItem.clone(true, true);
				}
				$item.attr("nid", dat.id);
				$item.attr("level", level * 1 + 1);
				$item.css("padding-left", level * padding + "px");
				$item.find(".tree-item-title").html(dat.name);
				body.append($item);
				if ($body) {
					body.append($body);
				}
			}
		}
	});
}
//==================load data]]

function initTreeEvent() {
	$(".tree-item").click(treeItemClick);
	$(".tree-item").dblclick(treeItemDblClick);
}

$(function() {
	$(".nav-item").click(navItemClick);
	initTreeEvent();
	
	loadNotes(); //load data
});