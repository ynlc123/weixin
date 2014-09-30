//初始化编辑器
var um = UM.getEditor('myEditor');

$(function() {
	//提交表单
	$("button").click(function() {
		var _data = "from=ajax&content=" + um.getContent();
		$.ajax({
			url : "/center/linkus/update.htm",
			data : _data,
			type : "post",
			dataType : "json",
			success : function(data) {
				//登录超时
				if(data.isLogout) {
					tipTimeout(data.msg);
					return;
				}
				
				tip(data.msg);
			},
			error : function() {
				tip("系统异常，操作失败！");
			}
		});
	});
});