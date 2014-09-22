<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>编辑我的资料</title>
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
	    <form action="/center/customer/update.htm" method="post" class="form-horizontal" role="form" style="width: 500px;max-width:100%;margin-left: auto;margin-right: auto">
	        <legend><h6 style="font-weight: bold">我的资料</h6></legend>
	        <div class="form-group">
	            <label for="realName" class="col-sm-3 control-label">姓名</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="realName" name="realName" placeholder="输入姓名" value="${customer.realName }">
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="mobile" class="col-sm-3 control-label">手机</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="mobile" name="mobile" placeholder="输入手机" value="${customer.mobile }">
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="phone" class="col-sm-3 control-label">固定电话</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="phone" name="phone" placeholder="输入固定电话" value="${customer.phone }">
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="fax" class="col-sm-3 control-label">传真</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="fax" name="fax" placeholder="输入传真" value="${customer.fax }">
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="email" class="col-sm-3 control-label">邮箱</label>
	            <div class="col-sm-9">
	                <input type="text" class="form-control input-sm" id="email" name="email" placeholder="输入邮箱" value="${customer.email }">
	            </div>
	        </div>
	        <div class="form-group text-center">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="submit" class="btn btn-wide btn-primary mrm">更新</button>
	            </div>
	        </div>
	    </form>
	</div>
	<!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>