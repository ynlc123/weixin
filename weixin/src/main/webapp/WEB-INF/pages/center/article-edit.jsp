<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>编辑文章</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="flat-ui/js/vendor/html5shiv.js"></script>
    <script src="flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <%-- 导航栏 --%>
    <%@ include file="../navbar.jsp" %>
    <!--更新内容-->
	<div class="container content">
	    <form class="form-horizontal" role="form" style="width: 800px;max-width:100%;height: 600px;margin-left: auto;margin-right: auto">
	        <legend><h6 style="font-weight: bold">编辑文章</h6></legend>
	        <div class="form-group">
	            <label for="title" class="col-sm-2 control-label">标题</label>
	            <div class="col-sm-10">
	                <input type="text" class="form-control input-sm" id="title" name="title" placeholder="输入文章标题" value="${article.title }">
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="myEditor" class="col-sm-2 control-label">内容</label>
	            <div class="col-sm-10">
	            <script type="text/plain" id="myEditor" name="content" style="width:650px;height:240px;">
                    ${article.content}
                </script>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="exampleInputFile" class="col-sm-2 control-label">图片</label>
	            <div class="col-sm-10">
	                <input type="file" id="exampleInputFile">
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label">文章类型</label>
	            <div class="col-sm-10">
	                <label class="radio" for="radio4a">
	                    <input type="radio" name="type" data-toggle="radio" value="TEXT" id="radio4a" class="custom-radio" <c:if test="${article.type=='TEXT' }">checked="checked"</c:if>><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                    文本内容
	                </label>
	                <label class="radio" for="radio4b">
	                    <input type="radio" name="type" data-toggle="radio" value="IMAGE_TEXT" id="radio4b" class="custom-radio" <c:if test="${article.type=='IMAGE_TEXT' }">checked="checked"</c:if>><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                    图文内容
	                </label>
	            </div>
	        </div>
	        <div class="form-group text-center">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="submit" class="btn btn-wide btn-primary mrm">提交保存</button>
	            </div>
	        </div>
	    </form>
	</div>
	<!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
	
	<!--百度编辑器-->
    <link href="/plugin/umeditor1_2_2/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/plugin/umeditor1_2_2/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugin/umeditor1_2_2/umeditor.min.js"></script>
    <script type="text/javascript" src="/plugin/umeditor1_2_2/lang/zh-cn/zh-cn.js"></script>
    
	<script type="text/javascript">
	    var um = UM.getEditor('myEditor');
	</script>
</body>
</html>