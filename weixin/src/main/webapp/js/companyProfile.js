//初始化编辑器
var um = UM.getEditor('myEditor');

$(function() {
	//提交表单
	$("button").click(function() {
		if(check_form) {
			var _data = "from=ajax&companyName="+$("#companyName").val()
						+ "&content=" + um.getContent()
						+ "&attachId=" + $(":input[name='attachId']").val();
			$.ajax({
				url : "/center/companyProfile/update.htm",
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
		}
	});
});

/**
 * 校验表单
 * @returns {Boolean}
 */
function check_form() {
	var flag = true;
	//校验标题
	if($("#companyName").val().trim().length==0) {
		$("#companyName").next(".help-block").removeClass("hidden").text("公司名称不能为空！");
		flag = false;
	} else {
		$("#companyName").next(".help-block").addClass("hidden").text("");
	}
	
	//校验内容
	if(um.getContentTxt().trim().length<1) {
		$("#content-tips").removeClass("hidden").text("公司简介不能为空！");
		flag = false;
	} else {
		$("#content-tips").addClass("hidden").text("");
	}
	
	return flag;
}