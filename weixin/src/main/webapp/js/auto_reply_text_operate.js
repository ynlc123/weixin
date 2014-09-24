$(function() {
	//关键词
	$("#keywords").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(keywords_null);
			$this.focus();
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	//内容
	$("#content").change(function() {
		$this = $(this);
		if($this.val().trim().length<1) {
			$this.next(".help-block").removeClass("hidden").text(content_null);
			$this.focus();
		} else {
			$this.next(".help-block").addClass("hidden").text("");
		}
	});
	
	$("form").submit(function() {
		if($("#keywords").val().trim().length<1) {
			$("#keywords").next(".help-block").removeClass("hidden").text(keywords_null);
			return false;
		}
		
		if($("#content").val().trim().length<1) {
			$("#content").next(".help-block").removeClass("hidden").text(content_null);
			return false;
		}
	});
	
	um.focus(false)
});

var keywords_null = "关键词不能为空！";
var content_null = "内容不能为空！";

