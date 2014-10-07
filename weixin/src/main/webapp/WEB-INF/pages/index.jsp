<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>米戈网</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
	
    <link href="/css/common.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="flat-ui/js/vendor/html5shiv.js"></script>
    <script src="flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
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
	<%-- 功能介绍 --%>
	<div class="container gongneng">
		<div class="row" style="margin-bottom:10px;">
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/cy.png">
				<i>微信也能够实时点餐</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/bm.png">
				<i>各种预约 一键即可<br/>短信邮件会立即通知商户</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/jd.png">
				<i>在线订房融入微信<br/>酒店营销多一条有力途径</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/kf.png">
				<i>沟通6亿用户创造无限商机</i>
			</div>
		</div>
		<div class="row" style="margin-bottom:10px;">
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/qc.png">
				<i>预约试驾或保养</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/qd.png">
				<i>二维码轻松一扫<br/>有效统计粉丝来源</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/sh.png">
				<i>吸引用户参与增强用户沉淀</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/sq.png">
				<i>建立微信社交<br/>平台社区虽小 见微知著</i>
			</div>
		</div>
		<div class="row" style="margin-bottom:10px;">
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/tg.png">
				<i>将优惠装入客户口袋</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/wxq.png">
				<i>活跃现场气氛让粉丝涨起来</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/yl.png">
				<i>在线挂号或咨询<br/>了解病情 微信都可以</i>
			</div>
			<div class="col-xs-6 col-md-3 text-center">
				<img alt="" src="/images/icons/yq.png">
				<i>电子请帖<br/>微信来袭提供用户特别服务</i>
			</div>
		</div>
	</div>
	
	<!--footer-->
	<%@ include file="footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>