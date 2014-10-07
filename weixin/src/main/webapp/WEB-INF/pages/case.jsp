<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>经典案例--米戈网</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
	
    <link href="/css/common.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="flat-ui/js/vendor/html5shiv.js"></script>
    <script src="flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    	.case div.row {
    		margin-top: 15px;
    	}
    </style>
</head>
<body>
    <%-- 导航栏 --%>
    <%@ include file="navbar.jsp"%>
    <%-- 广告滚动图 --%>
	<div class="container">
	    <div id="carousel-adv1" class="carousel slide" data-ride="carousel">
	        <!--Indicators-->
	        <ol class="carousel-indicators">
	            <li data-target="#carousel-adv1" data-slide-to="0" class="active"></li>
	            <li data-target="#carousel-adv1" data-slide-to="1"></li>
	            <li data-target="#carousel-adv1" data-slide-to="2"></li>
	        </ol>
	        <!--Wrapper for slides-->
	        <div class="carousel-inner" role="listbox">
	            <div class="item active">
	                <img src="http://blog.sinovision.net/attachments/2010/11/29/19737499134cf4251a4de83.jpg" style="width:100%;height:400px;" alt="...">
	                <div class="carousel-caption">...</div>
	            </div>
	            <div class="item">
	                <img src="http://news.xinhuanet.com/world/2007-05/25/xinsrc_1320504251102187145789.jpg" style="width:100%;height:400px;" alt="...">
	                <div class="carousel-caption">...</div>
	            </div>
	            <div class="item">
	                <img src="http://www.srfeiji.com/up_files/image004.jpg" style="width:100%;height:400px;" alt="...">
	                <div class="carousel-caption">...</div>
	            </div>
	        </div>
	        <!--controls-->
	        <a class="left carousel-control" href="#carousel-adv1" role="button" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left"></span>
	            <span class="sr-only">Previous</span>
	        </a>
	        <a class="right carousel-control" href="#carousel-adv1" role="button" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right"></span>
	            <span class="sr-only">Next</span>
	        </a>
	    </div>
	</div>
	<!-- 案例 -->
	<div class="container case">
		<div class="row">
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/1.png"></div>
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/2.png"></div>
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/3.png"></div>
		</div>
		<div class="row">
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/4.png"></div>
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/5.png"></div>
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/6.png"></div>
		</div>
		<div class="row">
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/7.png"></div>
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/8.png"></div>
			<div class="col-xs-4 text-center"><img class="img-thumbnail" src="/images/case/9.png"></div>
		</div>
	</div>
	<!--footer-->
	<%@ include file="footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>