$(function() {
	//表单提交前校验
	$("button[type='button']").click(submit_form);
	
	//公众号原始id
	$("#originalId").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(originalId_null);
		} else {
			checkOriginalId($this.val());
		}
	});
	
	//公众微信号
	$("#platformNo").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(platformNo_null);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//公众号用户名
	$("#userName").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(userName_null);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//公众号密码
	$("#password").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(password_null);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//公众号AppID
	$("#appId").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(appId_null);
		} else {
			checkAppId($this.val());
		}
	});
	
	//公众号AppSecret
	$("#appSecret").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(appSecret_null);
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
});

var originalId_null = "公众号原始id不能为空！";
var platformNo_null = "公众微信号不能为空！";
var userName_null = "公众号用户名不能为空！";
var password_null = "公众号密码不能为空！";
var appId_null = "公众号AppID不能为空！";
var appSecret_null = "公众号AppSecret不能为空！";
var platformType_null = "公众号类型不能为空！";

/**
 * 校验表单
 * @returns {Boolean}
 */
function check_form() {
	var flag = true;

	//公众号原始id
	if($("#originalId").val().trim().length==0) {
		$("#originalId").next(".help-block").removeClass("hidden").text(originalId_null);
		flag = false;
	}

	//公众微信号
	if($("#platformNo").val().trim().length==0) {
		$("#platformNo").next(".help-block").removeClass("hidden").text(platformNo_null);
		flag = false;
	}
	
	//公众号用户名
	if($("#userName").val().trim().length==0) {
		$("#userName").next(".help-block").removeClass("hidden").text(userName_null);
		flag = false;
	}
	
	//公众号密码
	if($("#password").val().trim().length==0) {
		$("#password").next(".help-block").removeClass("hidden").text(password_null);
		flag = false;
	}
	
	//公众号AppID
	if($("#appId").val().trim().length==0) {
		$("#appId").next(".help-block").removeClass("hidden").text(appId_null);
		flag = false;
	}
	
	//公众号AppSecret
	if($("#appSecret").val().trim().length==0) {
		$("#appSecret").next(".help-block").removeClass("hidden").text(appSecret_null);
		flag = false;
	}
	
	//公众号类型
	if($(":radio[name='platformType']").val().trim().length==0) {
		$("#type_tips").removeClass("hidden").text(platformType_null);
		flag = false;
	}
	
	return flag;
}

/**
 * 提交表单
 */
function submit_form() {
	if(check_form()) {
		var data = "originalId="+$("#originalId").val()+"&platformNo="+$("#platformNo").val()
		           +"&userName="+$("#userName").val()+"&password="+$("#password").val()
		           +"&appId="+$("#appId").val()+"&appSecret="+$("#appSecret").val()
		           +"&platformType="+$(":radio[name='platformType']:checked").val();
		$.ajax({
			url:"/center/platform/update.htm",
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
 * 校验公众号原始id
 * @param originalId
 */
function checkOriginalId(originalId) {
	$.ajax({
		url:"/center/platform/checkOriginalId.htm",
		data:"originalId="+originalId,
		type:"post",
		dataType:"json",
		success:function(data) {
			if(!data.success) {
				$("#originalId").next(".help-block").removeClass("hidden").text(data.msg);
			} else {
				$("#originalId").next(".help-block").addClass("hidden").text("");
			}
		},
		error:function() {
			tip("校验公众号原始id失败！");
		}
	});
}

/**
 * 校验公众号appId
 * @param appId
 */
function checkAppId(appId) {
	$.ajax({
		url:"/center/platform/checkAppId.htm",
		data:"appId="+appId,
		type:"post",
		dataType:"json",
		success:function(data) {
			if(!data.success) {
				$("#appId").next(".help-block").removeClass("hidden").text(data.msg);
			} else {
				$("#appId").next(".help-block").addClass("hidden").text("");
			}
		},
		error:function() {
			tip("校验公众号AppID失败！");
		}
	});
}
