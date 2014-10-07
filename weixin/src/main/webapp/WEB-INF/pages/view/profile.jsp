<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        <h1>公司简介</h1>
    </div>
    <div data-role="content">
    	<img style="width:100%;" src="http://img.article.pchome.net/00/35/91/45//pic_lib/wm/Meinv78.jpg">
    	<p style="font-size:12px;width:150px;margin-left:auto;margin-right:auto;">${profile.companyName }</p>
        <p style="font-size:12px;">${profile.content }</p>
        <div data-role="footer" data-position="fixed">
            <div data-role="navbar">
                <ul>
                    <li><a class="ui-btn-active" href="/view/profile.htm?originalId=${platform.originalId }" data-icon="home">简介</a></li>
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