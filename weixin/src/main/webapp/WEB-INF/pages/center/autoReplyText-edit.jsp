<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>修改文本回复</title>
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
	<%-- 自动回复内容 --%>
	<div class="container content">
	    <form action="/center/autoReplyText/update.htm" method="post" class="form-horizontal" role="form" style="width: 800px;max-width:100%;height: 600px;margin-left: auto;margin-right: auto">
	        <input type="hidden" name="uuid" value="${autoReplyText.uuid }">
	        <legend><h6 style="font-weight: bold">修改文本回复</h6></legend>
	        <div class="form-group">
	            <label for="keywords" class="col-sm-2 control-label">关键词</label>
	            <div class="col-sm-10">
	                <input type="text" class="form-control input-sm" id="keywords" name="keywords" placeholder="输入关键词" maxlength="10" value="${autoReplyText.keywords }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="myEditor" class="col-sm-2 control-label">内容</label>
	            <div class="col-sm-10">
		        <textarea rows="8" style="width: 100%;" name="content" id="content" maxlength="500">${autoReplyText.content }</textarea>
                <span class="help-block" id="content_tips"></span>
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
	<script type="text/javascript" src="/js/auto_reply_text_operate.js"></script>
	
</body>
</html>