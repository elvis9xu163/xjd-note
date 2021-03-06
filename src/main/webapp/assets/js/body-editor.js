window.openNote = function(id, isNoteBook) {
	if (isNoteBook) {
		$EDITORUI["edui6"]._onClick();
		$("#editorDiv").hide();
	} else {
		$("#editorDiv").show();
		$("input[name='id']").val(id);
		$.get(readNoteUrl + "?" + $.param({id: id}), function(data) {
			ue.setContent(data);
			if (data.length != 0) {
				$EDITORUI["edui7"]._onClick();
				$("#edui6").prev().css("text-align", "center").html("<button type='button' onclick='return $EDITORUI[\"edui6\"]._onClick();'>启用编辑</button>");
				$("#edui6_body").remove();
			} else {
				$EDITORUI["edui6"]._onClick();
			}
		});
	}
}

window.saveNoteResult = function(result) {
	if (result) {
		$("#saveSuccessTemplate").clone().appendTo($("#edui2").append()).fadeIn("slow").delay(1000).fadeOut("slow").delay(2000).fadeIn("slow").delay(1000).fadeOut("slow", function() {
			$(this).remove();
		});
	} else {
		$("#saveFailTemplate").clone().appendTo($("#edui2").append()).fadeIn("slow").delay(1000).fadeOut("slow").delay(2000).fadeIn("slow").delay(1000).fadeOut("slow", function() {
			$(this).remove();
		});
	}
}

window.adjustUIHeight = function() {
	/*
	 * window.parent.debug( $("body").height()); var h = $("body").height() -
	 * $("#edui1_toolbarbox").height() - $("#edui1_bottombar").height() -20;
	 * ue.setHeight(h);
	 */
}
window.adjustUIWidth = function() {
	var w = $("#editor").width();
	$("#edui1").width(w);
	$("#edui1_iframeholder").width(w);
}
window.adjustUISize = function() {
	adjustUIWidth();
	adjustUIHeight();
}

$(function() {
	window.ue = UE.getEditor('editor');
	
	ue.addListener("ready", function() {
		window.parent.editorReady = true;
		$(window.parent).resize();
		/*
		 * $($("#ueditor_0")[0].contentWindow).resize(function(e) {
		 * this.parent.adjustUIHeight(); });
		 */
	});
	
	
	$("#btnSave").click(function() {
		this.form.submit();
	});
});