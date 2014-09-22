$(function() {
	//表单提交前校验
	$("button[type='button']").click(submit_form);
	
	//账户
	$("#name").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(account_null);
		} else {
			//$this.next(".help-block").addClass("hidden").text("");
			checkUser(this,"此账户已被使用！");
		}
	});
	
	//密码
	$("#password").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(password_null);
		} else if($("#password").val()!=$("#re-password").val()) {
			$this.next(".help-block").addClass("hidden").text("");
			$("#re-password").next(".help-block").removeClass("hidden").text(not_eq_password);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
			$("#re-password").next(".help-block").addClass("hidden").text("");
		}
	});
	
	//确认密码
	$("#repassword").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(re_password_null);
		} else if($("#password").val()!=$("#repassword").val()) {
			$this.next(".help-block").removeClass("hidden").text(not_eq_password);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//手机号
	$("#mobile").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next().next(".help-block").removeClass("hidden").text(phone_null);
		} else if(!mobile.test($this.val().trim())) {
			$this.next().next(".help-block").removeClass("hidden").text(invalid_phone);
		} else {
			//$this.next(".help-block").addClass("hidden").text("");
			checkUser(this,"此手机号已被使用！");
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
			//$this.next(".help-block").addClass("hidden").text("");
			checkUser(this,"此邮箱已被使用！");
		}
	});
	
	//重置
	$(":reset").click(function() {
		$(".help-block").addClass("hidden").text("");
	});
});

var account_null = "账户不能为空！";
var password_null = "密码不能为空！";
var re_password_null = "确认密码不能为空！";
var userName_null = "姓名不能为空！";
var phone_null = "手机号不能为空！";
var code_null = "验证码不能为空！";
var email_null = "邮箱不能为空！";
var invalid_phone = "手机号不正确，请重新输入！";
var invalid_email = "邮箱输入有误，请重新输入！";
var not_eq_password = "两次输入的密码不一致！";
var mobile = /^0?(13[0-9]|15[012356789]|18[0123456789]|14[57])[0-9]{8}$/;
var email = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
var idcard_no = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;

/**
 * 校验表单
 * @returns {Boolean}
 */
function check_form() {
	var flag = true;

	//校验账户
	if($("#name").val().trim().length==0) {
		//$("#name").focus();
		$("#name").next(".help-block").removeClass("hidden").text(account_null);
		flag = false;
	}
	
	//校验密码
	if($("#password").val().trim().length==0) {
		//$("#password").focus();
		$("#password").next(".help-block").removeClass("hidden").text(password_null);
		flag = false;
	}
	
	//校验确认密码
	if($("#repassword").val().trim().length==0) {
		//$("#repassword").focus();
		$("#repassword").next(".help-block").removeClass("hidden").text(re_password_null);
		flag = false;
	} else if ($("#password").val().trim() != $("#repassword").val().trim()) {
		//$("#repassword").focus();
		$("#repassword").next(".help-block").removeClass("hidden").text(not_eq_password);
		flag = false;
	}

	//校验手机号
	if($("#mobile").val().trim().length==0) {
		//$("#mobile").focus();
		$("#mobile").next(".help-block").removeClass("hidden").text(phone_null);
		flag = false;
	} else if(!mobile.test($("#mobile").val().trim())){
		//$("#mobile").focus();
		$("#mobile").next().next(".help-block").removeClass("hidden").text(invalid_phone);
		flag = false;
	}
	
	//校验邮箱
	if($("#email").val().trim().length==0) {
		//$("#email").focus();
		$("#email").next(".help-block").removeClass("hidden").text(email_null);
		flag = false;
	} else if(!email.test($("#email").val())) {
		//$("#email").focus();
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
		var data = "name="+$("#name").val()+"&password="+$("#password").val()
		           +"&repassword="+$("#repassword").val()+"&mobile="+$("#mobile").val()
		           +"&email="+$("#email").val();
		$.ajax({
			url:"/register_go.htm",
			data:data,
			type:"post",
			dataType:"json",
			success:function(data) {
				if(data.reCode=='-4') {
					$("#"+data.target).focus();
					$("#"+data.target).siblings(".help-block").removeClass("hidden").text(data.regMsg);
				} else if(data.reCode=='00') {
					window.location="/register_success.htm";
				} else if(data.reCode=='02') {
					$("#code").next(".help-block").removeClass("hidden").text(data.reMsg);
				} else {
					window.location="/register_failure.htm";
				}
			},
			error:function() {
				window.location="/register_failure.htm";
			}
		});
	} else {
		return false;
	}
}

/**
 * 获取手机验证码
 */
/*function sendPhoneCode() {
	$phone = $("#phone");
	if($phone.val().trim().length<1) {
		$("#phone").focus();
		$phone.next().next(".help-block").removeClass("hidden").text(phone_null);
		return;
	} else if(!mobile.test($("#phone").val().trim())){
		$("#phone").focus();
		$("#phone").next().next(".help-block").removeClass("hidden").text(invalid_phone);
		return;
	}
	//隐藏验证码提示信息
	$phone.next().next(".help-block").addClass("hidden").text("");
	
	$.ajax({
		url:"/send_phone_code.htm",
		type:"post",
		dataType:"json",
		data:"phone="+$("#phone").val()+"&randomCode="+$("#randomCode").val(),
		success:function(data) {
			if(data.reCode=='-4') {
				$("#"+data.target).focus();
				$("#"+data.target).siblings(".help-block").removeClass("hidden").text(data.regMsg);
			} else if(data.reCode=='00') {
				$("#phone").next().next(".help-block").css("color","#00cc00").removeClass("hidden").text("验证码已发送，请注意查收！");
				
				//下次获取验证码时间
				remainSendTime();
			} else if(data.reCode=='-1') {
				$("#phone").next().next(".help-block").removeClass("hidden").text("服务器未响应，请稍后再试！");
			} else {
				$("#phone").next().next(".help-block").removeClass("hidden").text("验证码发送失败！");
			}
		},
		error:function() {
			$("#phone").next().next(".help-block").removeClass("hidden").text("验证码发送失败！");
		}
	});
}*/

/**
 * 校验用户
 */
function checkUser(obj,msg) {
	$this = $(obj);
	$.ajax({
		url:"/register/check_name.htm",
		type:"post",
		dataType:"json",
		data:"name="+$this.val(),
		success:function(data) {
			if(!data.success) {
				$this.siblings(".help-block").removeClass("hidden").text(msg);
			} else {
				$this.siblings(".help-block").addClass("hidden");
			}
		},
		error:function() {
			$this.siblings(".help-block").removeClass("hidden").text("校验用户名异常！");
		}
	});
}

/**
 * 下次获取验证码时间
 * @param time
 */
var time=120,remainTime;
function remainSendTime() {
	if(time>0) {
		//只读手机号
		$("#phone").attr("readonly","readonly");
		
		$("#getCode").addClass("disabled").text("剩余"+time+"秒");
		time = time-1;
		remainTime = setTimeout(remainSendTime,1000);
	} else {
		$("#getCode").removeClass("disabled").text("获取验证码");
		//clearTimeout(remainTime);
		
		//去除只读属性
		$("#phone").removeAttr("readonly");
	}
}