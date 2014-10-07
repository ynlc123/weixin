<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>修改密码</title>
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
	<!--更新内容-->
	<div class="container content">
	    <form class="form-horizontal" role="form" style="width: 500px;max-width:100%;height: 370px;margin-left: auto;margin-right: auto">
	        <legend><h6 style="font-weight: bold">修改密码</h6></legend>
	        <div class="form-group">
	            <label class="col-sm-3 control-label">用户名</label>
	            <div class="col-sm-9" style="margin-top: 6px;">
	                ${loginCustomer.name }
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="oldpassword" class="col-sm-3 control-label">旧密码</label>
	            <div class="col-sm-9">
	                <input type="password" class="form-control input-sm" id="oldpassword" name="oldpassword" placeholder="输入旧密码">
	                <span class="help-block">${old_psw_msg }</span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="newpassword" class="col-sm-3 control-label">新密码</label>
	            <div class="col-sm-9">
	                <input type="password" class="form-control input-sm" id="newpassword" name="newpassword" placeholder="输入新密码">
	                <span class="help-block">${new_psw_msg }</span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="re_newpassword" class="col-sm-3 control-label">确认密码</label>
	            <div class="col-sm-9">
	                <input type="password" class="form-control input-sm" id="re_newpassword" name="re_newpassword" placeholder="再次输入密码">
	                <span class="help-block">${re_new_psw_msg }</span>
	            </div>
	        </div>
	        <div class="form-group text-center">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="button" class="btn btn-wide btn-primary mrm">提交修改</button>
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
	<script src="/js/password.js"></script>
</body>
</html>