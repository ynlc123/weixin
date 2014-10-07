<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>${article.title }</title>
    <link rel="stylesheet" href="/plugin/jquery_mobile/css/jquery.mobile-1.4.4.min.css">
    <!-- <link rel="stylesheet" type="text/css" href="/plugin/jquery-mobile-flat-ui/css/jquery.mobile.flatui.css" /> -->
    <script src="/plugin/jquery.1.11.1-min.js"></script>
    <script src="/plugin/jquery_mobile/js/jquery.mobile-1.4.4.min.js"></script>
</head>
<body>
<div data-role="page" id="header">
    <div data-role="navbar">
        <ul>
            <li><a href="javascript:history.go(-1);" data-icon="back">返回</a></li>
        </ul>
    </div>
    <div data-role="content">
    	<h4 style="text-align: center;">${article.title }</h4>
    	<h6 style="text-align: center;"><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd" /></h6>
        <img style="width:100%;" src="http://192.168.1.3:8080/${article.image.path }">
        <p>${article.content }</p>
        <div data-role="navbar">
	        <ul>
	            <li><a href="javascript:history.go(-1);" data-icon="back">返回</a></li>
	            <li><a href="javascript:;" onclick="$.mobile.silentScroll(0)" data-icon="arrow-u">顶部</a></li>
	        </ul>
	    </div>
        <div data-role="footer" data-position="fixed">
            <div data-role="navbar">
                <ul>
                    <li><a href="/view/profile.htm?originalId=${platform.originalId }" data-icon="home">简介</a></li>
                    <li><a href="/view/article/list.htm?originalId=${platform.originalId }" data-icon="grid">文章列表</a></li>
                    <li><a href="/view/activities/list.htm?originalId=${platform.originalId }" data-icon="star">近期活动</a></li>
                    <li><a href="/view/linkus.htm?originalId=${platform.originalId }" data-icon="phone">联系我们</a></li>
                </ul>
            </div><!-- /navbar -->
        </div><!-- /footer -->
    </div>
</div>
</body>
</html>