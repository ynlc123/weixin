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