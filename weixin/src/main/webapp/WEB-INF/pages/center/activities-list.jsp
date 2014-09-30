<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>活动列表</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
    <link href="/plugin/artDialog/ui-dialog.css" rel="stylesheet">

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
	    <h6 style="font-weight: bold; display:inline;">活动列表</h6>
	    <a href="/center/activities/new.htm" class="btn btn-primary btn-sm pull-right">发布活动</a>
	    <table class="table table-hover table-striped">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>标题</th>
	            <th>发布时间</th>
	            <th>开始时间</th>
	            <th>结束时间</th>
	            <th>状态</th>
	            <th>操作</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${pageView.records }" var="activities" varStatus="status">
		        <tr>
		            <td>${status.index+1 }</td>
		            <td><a href="#" title="${activities.title }">${activities.title }</a></td>
		            <td><fmt:formatDate value="${activities.createTime}" pattern="yyyy-MM-dd" /></td>
		            <td>${activities.startTime }</td>
		            <td>${activities.endTime }</td>
		            <td>
		            	<c:if test="${activities.status==1 }">正常</c:if>
		            	<c:if test="${activities.status==0 }"><i style="font-style:normal;color:#ff0000;">已禁用</i></c:if>
		            </td>
		            <td data-id="${activities.uuid }">
		            	<c:if test="${activities.status==1 }"><a href="javascript:;" class="btn btn-warning btn-xs forbid">禁用</a></c:if>
			            <c:if test="${activities.status==0 }"><a href="javascript:;" class="btn btn-success btn-xs enable">启用</a></c:if>
			            <a href="/center/activities/edit.htm?uuid=${activities.uuid }" target="_blank" class="btn btn-info btn-xs">编辑</a>
			            <a href="javascript:;" class="btn btn-danger btn-xs delete">删除</a>
		            </td>
		        </tr>
	        </c:forEach>
	        <c:if test="${empty pageView.records }">
	        <tr>
	        	<td colspan="7">
	        		<div class="alert alert-warning text-center" style="height: 100px;line-height: 100px;" role="alert">
	        			您还没有发不过活动！<a href="/center/activities/new.htm" class="btn btn-primary btn-sm">发布活动</a>
	        		</div>
	        	</td>
	        </tr>
	        </c:if>
	        </tbody>
	    </table>
	</div>
	<c:if test="${not empty pageView.records }">
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
	<script src="/plugin/artDialog/dialog-min.js"></script>
	<script src="/plugin/base64.js"></script>
	<script src="/js/tips.js"></script>
	<script src="/js/activities_list.js"></script>
</body>
</html>