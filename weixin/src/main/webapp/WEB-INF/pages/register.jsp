<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>用户注册</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="/plugin/flat-ui/js/vendor/html5shiv.js"></script>
    <script src="/plugin/flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <%-- 导航栏 --%>
    <%@ include file="navbar.jsp" %>
    <div class="container">
        <form class="form-horizontal" role="form" style="width: 500px;max-width:100%;margin-left: auto;margin-right: auto">
            <legend><h6 style="font-weight: bold">用户注册</h6></legend>
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control input-sm" name="name" id="name" placeholder="输入用户名" value="${customer.name }">
                    <span class="help-block">${name_msg }</span>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">密码</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control input-sm" id="password" name="password" placeholder="输入密码">
                    <span class="help-block">${password_msg }</span>
                </div>
            </div>
            <div class="form-group">
                <label for="repassword" class="col-sm-3 control-label">确认密码</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control input-sm" id="repassword" name="repassword" placeholder="再次输入密码">
                    <span class="help-block">${repassword_msg }</span>
                </div>
            </div>
            <div class="form-group">
                <label for="mobile" class="col-sm-3 control-label">手机</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control input-sm" id="mobile" name="mobile" placeholder="输入手机" value="${customer.mobile }">
                    <span class="help-block">${mobile_msg }</span>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">邮箱</label>
                <div class="col-sm-9">
                    <input type="email" class="form-control input-sm" id="email" name="email" placeholder="输入邮箱" value="${customer.email }">
                    <span class="help-block">${email_msg }</span>
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-wide btn-primary mrm">登录</button>
                    <button type="reset" class="btn btn-wide btn-default">重置</button>
                </div>
            </div>
        </form>
    </div>
    <!--footer-->
	<%@ include file="footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="/js/register.js"></script>
</body>
</html>