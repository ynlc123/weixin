$(function() {
	$(".forbid").click(function() {
		forbid($(this));
	});
	
	$(".enable").click(function() {
		enable($(this));
	});
	
	$(".delete").click(function() {
		del($(this));
	});
});

/**
 * 禁用
 * @param $obj
 */
function forbid($obj) {
	$.ajax({
		url: "/center/autoReplyText/forbid.htm",
		data:"from=ajax&uuid="+$obj.parent().attr("data-id"),
		type:"post",
		dataType:"json",
		success: function(data) {
			//登录超时
			if(data.isLogout) {
				tipTimeout(data.msg);
				return;
			}
			
			if(data.success) {
				$obj.parent().prev().html("<i style='font-style:normal;color:#ff0000;'>已禁用</i>");
				$obj.removeClass("btn-warning").removeClass("forbid").unbind("click")
					.addClass("btn-success").addClass("enable").text("启用")
					.bind("click",function() {
						enable($(this));
					});
			}
			tip(data.msg);
		},
		error: function() {
			tip("系统异常，操作失败！");
		}
	});
}

/**
 * 启用
 * @param $obj
 */
function enable($obj) {
	$.ajax({
		url: "/center/autoReplyText/enable.htm",
		data:"from=ajax&uuid="+$obj.parent().attr("data-id"),
		type:"post",
		dataType:"json",
		success: function(data) {
			//登录超时
			if(data.isLogout) {
				tipTimeout(data.msg);
				return;
			}
			
			if(data.success) {
				$obj.parent().prev().html("<i style='font-style:normal;color:#red;'>正常</i>");
				$obj.removeClass("btn-success").removeClass("enable").unbind("click")
					.addClass("btn-warning").addClass("forbid").text("禁用")
					.bind("click",function() {
						forbid($(this));
					});
			}
			tip(data.msg);
		},
		error: function() {
			tip("系统异常，操作失败！");
		}
	});
}

/**
 * 删除
 */
function del($obj) {
	$.ajax({
		url: "/center/autoReplyText/delete.htm",
		data:"from=ajax&uuid="+$obj.parent().attr("data-id"),
		type:"post",
		dataType:"json",
		success: function(data) {
			//登录超时
			if(data.isLogout) {
				tipTimeout(data.msg);
				return;
			}
			
			if(data.success) {
				tipAndReload(data.msg);
			} else {
				tip(data.msg);
			}
		},
		error: function() {
			tip("系统异常，操作失败！");
		}
	});
}

/**
 * 提示信息
 * @param msg
 */
function tip(msg) {
	var d = dialog({
		title: '提示信息',
	    content: msg
	});
	d.show();
	setTimeout(function () {
	    d.close().remove();
	}, 2000);
}

/**
 * 提示并重新加载
 * @param msg
 */
function tipAndReload(msg) {
	var d = dialog({
		title: '提示信息',
	    content: msg
	});
	d.show();
	setTimeout(function () {
	    window.location.reload();
	}, 2000);
}

/**
 * 提示超时
 */
function tipTimeout(msg) {
	var url = window.location+"";
	var d = dialog({
		title: '提示信息',
	    content: msg,
	    okValue: '确定',
	    ok: function () {
	    	window.location="/login.htm?sendUrl="+new Base64().encode(url);
	    }
	});
	d.show();
}