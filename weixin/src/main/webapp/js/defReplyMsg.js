$(function() {
	$("button").click(function() {
		if($("#content").val().trim().length<1) {
			$("#content").next(".help-block").removeClass(".hidden").text("内容不能为空！");
			$("#content").focus();
			return;
		} else {
			$("#content").next(".help-block").addClass(".hidden").text("");
		}
		
		$.ajax({
			url: "/center/defReplyMsg/update.htm",
			data:"from=ajax&content="+$("#content").val(),
			type:"post",
			dataType:"json",
			success: function(data) {
				//登录超时
				if(data.isLogout) {
					tipTimeout(data.msg);
					return;
				}
				
				tip(data.msg);
			},
			error: function() {
				tip("系统异常，操作失败！");
			}
		});
	})
});

