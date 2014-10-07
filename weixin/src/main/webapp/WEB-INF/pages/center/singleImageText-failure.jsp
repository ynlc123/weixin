<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>操作单图文失败</title>
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
    <%@ include file="../navbar.jsp" %>
	<div class="container" style="min-height: 370px;">
        <div class="alert alert-danger" role="alert" style="margin-top: 100px;margin-bottom: auto;width: 500px; max-width:100%; height: 200px;margin-left: auto;margin-right: auto;">
        	<%
        		String uuid = (String)request.getParameter("uuid");
        	%>
        	<%
        		if(uuid == null) {
        	%>
	        	<div class="col-xs-12 text-center" style="padding: 20px;font-weight: bold;">添加单图文失败！</div>
	        	<div class="col-xs-12 text-center" style="margin-top: 30px;">
	        		<a href="/center/singleImageText/new.htm" class="btn btn-primary">重新添加</a>
	        		<a href="/center/singleImageText/list.htm" class="btn btn-success">管理单图文</a>
	        	</div>
	        <%
        		}
	        %>
        	<%
        		if(uuid != null) {
        	%>
        		<div class="col-xs-12 text-center" style="padding: 20px;font-weight: bold;">修改单图文失败！</div>
	        	<div class="col-xs-12 text-center" style="margin-top: 30px;">
	        		<a href="/center/singleImageText/list.htm" class="btn btn-success">管理单图文</a>
	        	</div>
        	<%
        		}
	        %>
        </div>
    </div>
	<!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>