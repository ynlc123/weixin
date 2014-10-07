//初始化编辑器
var um = UM.getEditor('myEditor');

$(function() {
	//关键词
	$("#keywords").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text("关键词不能为空！");
		} else {
			$this.next(".help-block").addClass("hidden").text("");
			$this.focus();
		}
	});
	
	//标题
	$("#title").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text("标题不能为空！");
		} else {
			$this.next(".help-block").addClass("hidden").text("");
			$this.focus();
		}
	});
	
	//表单提交前校验
	$("form").submit(function() {
		var flag = true;
		//校验关键词
		if($("#keywords").val().trim().length==0) {
			$("#keywords").next(".help-block").removeClass("hidden").text("关键词不能为空！");
			flag = false;
		} else {
			$("#keywords").next(".help-block").addClass("hidden").text("");
		}
		
		//校验内容
		if(um.getContentTxt().trim().length<1) {
			$("#content-tips").removeClass("hidden").text("内容不能为空！");
			flag = false;
		} else {
			$("#content-tips").addClass("hidden").text("");
		}
		
		//校验图片
		/*if(!$(":input[name='attachId']").val()) {
			$("#image-tips").removeClass("hidden").text("请上传图片！");
			flag = false;
		} else {
			$("#image-tips").addClass("hidden").text("");
		}*/
		
		return flag;
	});
});