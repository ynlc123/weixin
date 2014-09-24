$(function() {
	//表单提交前校验
	$("button[type='button']").click(submit_form);
	
	//姓名
	$("#realName").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(realName_null);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//手机号
	$("#mobile").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$("#mobile").next(".help-block").removeClass("hidden").text(mobile_null);
		} else if(!mobile.test($("#mobile").val().trim())){
			$("#mobile").next(".help-block").removeClass("hidden").text(invalid_mobile);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//邮箱
	$("#email").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(email_null);
		} else if(!email.test($this.val().trim())) {
			$this.next(".help-block").removeClass("hidden").text(invalid_email);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//重置
	$(":reset").click(function() {
		$(".help-block").addClass("hidden").text("");
	});
});

var realName_null = "姓名不能为空！";
var mobile_null = "手机号不能为空！";
var email_null = "邮箱不能为空！";
var invalid_mobile = "手机号不正确，请重新输入！";
var invalid_email = "邮箱输入有误，请重新输入！";
var mobile = /^0?(13[0-9]|15[012356789]|18[0123456789]|14[57])[0-9]{8}$/;
var email = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;

/**
 * 校验表单
 * @returns {Boolean}
 */
function check_form() {
	var flag = true;

	//校验姓名
	if($("#realName").val().trim().length==0) {
		$("#realName").next(".help-block").removeClass("hidden").text(realName_null);
		flag = false;
	}

	//校验手机号
	if($("#mobile").val().trim().length==0) {
		$("#mobile").next(".help-block").removeClass("hidden").text(phone_null);
		flag = false;
	} else if(!mobile.test($("#mobile").val().trim())){
		$("#mobile").next().next(".help-block").removeClass("hidden").text(invalid_phone);
		flag = false;
	}
	
	//校验邮箱
	if($("#email").val().trim().length==0) {
		$("#email").next(".help-block").removeClass("hidden").text(email_null);
		flag = false;
	} else if(!email.test($("#email").val())) {
		$("#email").next(".help-block").removeClass("hidden").text(invalid_email);
		flag = false;
	}
	
	return flag;
}

/**
 * 提交表单
 */
function submit_form() {
	if(check_form()) {
		var data = "realName="+$("#realName").val()+"&mobile="+$("#mobile").val()
		           +"&phone="+$("#phone").val()+"&fax="+$("#fax").val()
		           +"&email="+$("#email").val();
		$.ajax({
			url:"/center/customer/update.htm",
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