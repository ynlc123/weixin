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
    <title></title>
    <link rel="stylesheet" href="/plugin/jquery_mobile/css/jquery.mobile-1.4.4.min.css">
    <!-- <link rel="stylesheet" type="text/css" href="/plugin/jquery-mobile-flat-ui/css/jquery.mobile.flatui.css" /> -->
    <script src="/plugin/jquery.1.11.1-min.js"></script>
    <script src="/plugin/jquery_mobile/js/jquery.mobile-1.4.4.min.js"></script>
</head>
<body>
<div data-role="page">
    <div data-role="header" data-position="fixed">
        <h1>近期活动</h1>
    </div>
    <div data-role="content">
        <ul data-role="listview" data-inset="true">
        	<c:forEach items="${pageView.records }" var="article" varStatus="status">
		    <li><a href="/view/activities/detail.htm?uuid=${article.uuid }">${article.title }</a></li>
		    </c:forEach>
		</ul>
        <div data-role="footer" data-position="fixed">
            <div data-role="navbar">
                <ul>
                    <li><a href="/view/profile.htm?originalId=${platform.originalId }" data-icon="home">简介</a></li>
                    <li><a href="/view/article/list.htm?originalId=${platform.originalId }" data-icon="grid">文章列表</a></li>
                    <li><a class="ui-btn-active" href="/view/activities/list.htm?originalId=${platform.originalId }" data-icon="star">近期活动</a></li>
                    <li><a href="/view/linkus.htm?originalId=${platform.originalId }" data-icon="phone">联系我们</a></li>
                </ul>
            </div><!-- /navbar -->
        </div><!-- /footer -->
    </div>
</div>
</body>
</html>