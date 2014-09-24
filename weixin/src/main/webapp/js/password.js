$(function() {
	//表单提交前校验
	$("button[type='button']").click(submit_form);
	
	//旧密码
	$("#oldpassword").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(old_password_null);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//密码
	$("#newpassword").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(new_password_null);
		} else if($("#newpassword").val()!=$("#re-password").val()) {
			$this.next(".help-block").addClass("hidden").text("");
			$("#re_newpassword").next(".help-block").removeClass("hidden").text(not_eq_password);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
			$("#re_newpassword").next(".help-block").addClass("hidden").text("");
		}
	});
	
	//确认密码
	$("#re_newpassword").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(re_password_null);
		} else if($("#newpassword").val()!=$("#re_newpassword").val()) {
			$this.next(".help-block").removeClass("hidden").text(not_eq_password);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
});

var old_password_null = "旧密码不能为空！";
var new_password_null = "新密码不能为空！";
var re_password_null = "确认密码不能为空！";
var not_eq_password = "两次输入的密码不一致！";

/**
 * 校验表单
 * @returns {Boolean}
 */
function check_form() {
	var flag = true;

	//校验旧密码
	if($("#oldpassword").val().trim().length==0) {
		$("#oldpassword").next(".help-block").removeClass("hidden").text(old_password_null);
		flag = false;
	}

	//校验新密码
	if($("#newpassword").val().trim().length==0) {
		$("#newpassword").next(".help-block").removeClass("hidden").text(new_password_null);
		flag = false;
	}
	
	//校验确认密码
	if($("#re_newpassword").val().trim().length==0) {
		$("#re_newpassword").next(".help-block").removeClass("hidden").text(re_password_null);
		flag = false;
	}
	
	return flag;
}

/**
 * 提交表单
 */
function submit_form() {
	if(check_form()) {
		var data = "oldpassword="+$("#oldpassword").val()+"&newpassword="+$("#newpassword").val()
		           +"&re_newpassword="+$("#re_newpassword").val();
		$.ajax({
			url:"/center/customer/update_password.htm",
			data:data,
			type:"post",
			dataType:"json",
			success:function(data) {
				tip(data.msg);
			},
			error:function() {
				tip("服务繁忙，请稍后再试！");
			}
		});
	} else {
		return false;
	}
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