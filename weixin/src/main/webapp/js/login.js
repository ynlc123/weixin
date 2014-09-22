$(function() {
	//验证用户名
	$(":input[name='name']").change(function() {
		if($(this).val().trim().length<1) {
			$(this).next(".help-block").removeClass("hidden").text("用户名不能为空！");
		} else {
			$(this).next(".help-block").text("");
		}
	});
	
	//验证密码
	$(":input[name='password']").change(function() {
		if($(this).val().trim().length<1) {
			$(this).next(".help-block").removeClass("hidden").removeClass("hidden").text("密码不能为空！");
		} else {
			$(this).next(".help-block").removeClass("hidden").text("");
		}
	});
	
	//表单验证
	$("form").submit(function() {
		var flag = true;
		if($(":input[name='name']").val().trim().length<1) {
			$(":input[name='name']").next(".help-block").removeClass("hidden").text("用户名不能为空！");
			flag = false;
		}
		if($(":input[name='password']").val().trim().length<1) {
			$(":input[name='password']").next(".help-block").removeClass("hidden")/*.css("font-weight","bold")*/.text("密码不能为空！");
			flag = false;
		}
		return flag;
	});
	
	//重置表单
	$("button[type=reset]").click(function() {
		$(".help-block").addClass("hidden").text("");
	});
});