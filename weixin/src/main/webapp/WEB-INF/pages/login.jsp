<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>用户登录</title>
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
    <form action="/login_go.htm" method="post" class="form-horizontal" role="form" style="width: 500px;max-width:100%;height:370px;margin-left: auto;margin-right: auto">
        <input type="hidden" name="sendUrl" value="${sendUrl }">
        <legend><h6 style="font-weight: bold">用户登录</h6></legend>
        <c:if test="${not empty msg }">
        <div class="alert alert-danger text-center" role="alert">
		  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		  ${msg }
		</div>
		</c:if>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-sm" id="name" name="name" placeholder="输入用户名" value="${name }">
                <span class="help-block">${name_msg }</span>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control input-sm" id="password" name="password" placeholder="输入密码">
                <span class="help-block">${password_msg }</span>
            </div>
        </div>
        <div class="form-group text-center">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-wide btn-primary mrm">登录</button>
                <button type="reset" class="btn btn-wide btn-default">重置</button>
            </div>
        </div>
    </form>
    <!--footer-->
	<%@ include file="footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
	<script src="/js/login.js"></script>
</body>
</html>