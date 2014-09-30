//初始化编辑器
var um = UM.getEditor('myEditor');

$(function() {
	//标题
	$("#title").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text("活动标题不能为空！");
		} else {
			$this.next(".help-block").addClass("hidden").text("");
			$this.focus();
		}
	});
	
	//表单提交前校验
	$("form").submit(function() {
		var flag = true;
		//校验标题
		if($("#title").val().trim().length==0) {
			$("#title").next(".help-block").removeClass("hidden").text("活动标题不能为空！");
			flag = false;
		} else {
			$("#title").next(".help-block").addClass("hidden").text("");
		}
		
		//校验内容
		if(um.getContentTxt().trim().length<1) {
			$("#content-tips").removeClass("hidden").text("活动内容不能为空！");
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
		
		//校验起始时间
		if($("#startTime").val().trim().length<1) {
			$("#startTime-tips").removeClass("hidden").text("起始时间不能为空！");
			flag = false;
		} else {
			$("#startTime-tips").addClass("hidden").text("");
		}
		
		//终止起始时间
		if($("#endTime").val().trim().length<1) {
			$("#endTime-tips").removeClass("hidden").text("终止时间不能为空！");
			flag = false;
		} else {
			$("#endTime-tips").addClass("hidden").text("");
		}
		
		return flag;
	});
})