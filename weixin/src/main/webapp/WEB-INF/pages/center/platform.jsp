<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>设置公众号信息</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
    <link href="/plugin/artDialog/ui-dialog.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="/plugin/flat-ui/js/vendor/html5shiv.js"></script>
    <script src="/plugin/flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <%-- 导航栏 --%>
    <%@ include file="../navbar.jsp" %>
	<!--公众号内容-->
	<div class="container content">
        <c:if test="${empty platform }">
        <div class="alert alert-danger" role="alert" style="margin-bottom: auto;width: 600px;max-width: 100%; height: 50px;line-height: 50px; text-align: center; margin-left: auto;margin-right: auto;">温馨提醒：请先设置公众号信息！</div>
	    </c:if>
	    <form class="form-horizontal" role="form" style="width: 600px;max-width:100%;margin-left: auto;margin-right: auto">
	        <legend><h6 style="font-weight: bold">设置公众号</h6></legend>
	        <div class="form-group">
	            <label for="originalId" class="col-sm-3 control-label">公众号原始id</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="originalId" name="originalId" placeholder="输入公众号原始id" value="${platform.originalId }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="platformNo" class="col-sm-3 control-label">公众微信号</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="platformNo" name="platformNo" placeholder="输入公众微信号" value="${platform.platformNo }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="userName" class="col-sm-3 control-label">公众号用户名</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="userName" name="userName" placeholder="输入公众号用户名" value="${platform.userName }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="password" class="col-sm-3 control-label">公众号密码</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="password" name="password" placeholder="输入公众号密码" value="${platform.password }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="appId" class="col-sm-3 control-label">公众号AppID</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="appId" name="appId" placeholder="输入公众号AppID" value="${platform.appId }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="appSecret" class="col-sm-3 control-label">公众号AppSecret</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="appSecret" name="appSecret" placeholder="输入公众号AppSecret" value="${platform.appSecret }">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label">公众号类型</label>
	            <div class="col-sm-10">
	                <label class="radio" for="platformType-1">
	                    <input type="radio" name="platformType" data-toggle="radio" value="1" id="platformType-1" class="custom-radio" <c:if test="${platform.platformType==1 }">checked="checked"</c:if>><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                     服务号
	                </label>
	                <label class="radio" for="platformType-0">
	                    <input type="radio" name="platformType" data-toggle="radio" value="0" id="platformType-0" class="custom-radio" <c:if test="${platform.platformType==0 }">checked="checked"</c:if>><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                    订阅号
	                </label>
	                <span class="help-block" id="type_tips"></span>
	            </div>
	        </div>
	        <div class="form-group text-center">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="button" class="btn btn-wide btn-primary mrm">提交保存</button>
	            </div>
	        </div>
	    </form>
	</div>
	<!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="/plugin/artDialog/dialog-min.js"></script>
	<script src="/js/tips.js"></script>
	<script src="/js/platform.js"></script>
</body>
</html>