<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>管理自动回复</title>
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
	<!--活动列表-->
	<div class="container content">
	    <h6 style="font-weight: bold; display:inline;">图文回复列表</h6>
	    <a href="/center/autoReplyArticle/new.htm" class="btn btn-primary btn-sm pull-right" style="margin-left: 10px;">发布单图文</a>
	    <a href="/center/autoReplyArticle/new.htm" class="btn btn-primary btn-sm pull-right">发布多图文</a>
	    <table class="table table-hover table-striped">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>关键词</th>
	            <th>创建时间</th>
	            <th>类型</th>
	            <th>状态</th>
	            <th>操作</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${pageView.records }" var="autoReplyArticle" varStatus="status">
	        <tr>
	            <td>${status.index+1 }</td>
	            <td><a href="#" title="${autoReplyArticle.keywords }">${autoReplyArticle.keywords }</a></td>
	            <td><fmt:formatDate value="${autoReplyArticle.createTime}" pattern="yyyy-MM-dd" /></td>
	            <td>${autoReplyArticle.type.name }</td>
	            <td>
	            	<c:if test="${autoReplyArticle.status==1 }">正常</c:if>
	            	<c:if test="${autoReplyArticle.status==0 }"><i style="font-style:normal;color:#ff0000;">已禁用</i></c:if>
	            </td>
	            <td data-id="${autoReplyArticle.uuid }">
	            	<c:if test="${autoReplyArticle.status==1 }"><a href="javascript:;" class="btn btn-warning btn-xs forbid">禁用</a></c:if>
		            <c:if test="${autoReplyArticle.status==0 }"><a href="javascript:;" class="btn btn-success btn-xs enable">启用</a></c:if>
		            <a href="/center/activities/edit.htm?uuid=${autoReplyArticle.uuid }" target="_blank" class="btn btn-info btn-xs">编辑</a>
		            <a href="javascript:;" class="btn btn-danger btn-xs delete">删除</a>
	            </td>
	        </tr>
	        </c:forEach>
	        <c:if test="${empty pageView.records }">
	        <tr>
	        	<td colspan="7">
	        		<div class="alert alert-warning text-center" style="height: 100px;line-height: 100px;" role="alert">
	        			您还没有图文回复文章哦！<a href="/center/autoReplyArticle/new.htm" class="btn btn-primary btn-sm">发布活动</a>
	        		</div>
	        	</td>
	        </tr>
	        </c:if>
	        </tbody>
	    </table>
	</div>
	<c:if test="${empty pageView.records }">
	<div class="container">
	    <div class="pagination pull-right">
	        <ul>
	            <c:if test="${pageView.currentpage>1 }">
	            <li class="previous"><a href="?pageNo=${pageView.currentpage-1 }" class="fui-arrow-left"></a></li>
	            </c:if>
	            <c:if test="${pageView.currentpage<=1 }">
	            <li class="previous disabled"><a href="javascript:;" class="fui-arrow-left"></a></li>
	            </c:if>
	            <c:forEach begin="${pageView.pageindex.startindex }" end="${pageView.pageindex.endindex }" var="index">
	            <c:if test="${pageView.currentpage==index }">
	            	<li class="active"><a href="javascript:;">${index }</a></li>
	            </c:if>
	            <c:if test="${pageView.currentpage!=index }">
	            	<li><a href="?pageNo=${index }">${index }</a></li>
	            </c:if>
	            </c:forEach>
	            <c:if test="${pageView.currentpage<pageView.totalpage }">
	            <li class="next"><a href="?pageNo=${pageView.currentpage+1 }" class="fui-arrow-right"></a></li>
	            </c:if>
	            <c:if test="${pageView.currentpage>=pageView.totalpage }">
	            <li class="next disabled"><a href="javascript:;" class="fui-arrow-right"></a></li>
	            </c:if>
	        </ul>
	    </div>
	 </div>
	 </c:if>
    <!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>