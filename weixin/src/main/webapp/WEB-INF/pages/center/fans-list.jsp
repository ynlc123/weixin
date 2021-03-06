<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>管理粉丝</title>
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
	<%-- 粉丝列表 --%>
	<div class="container content">
	    <h6 style="font-weight: bold">粉丝列表</h6>
	    <table class="table table-hover table-striped">
	        <thead>
	        <tr>
	            <th>序号</th>
	            <th>头像</th>
	            <th>昵称</th>
	            <th>性别</th>
	            <th>省份/城市</th>
	            <th>关注时间</th>
	            <th>积分</th>
	        </tr>
	        </thead>
	        <tbody>
	        <tr>
	            <td>1</td>
	            <td>头像</td>
	            <td>绿竹</td>
	            <td>男</td>
	            <td>云南/昆明</td>
	            <td>2014-09-14</td>
	            <td>388</td>
	        </tr>
	        <tr>
	            <td>2</td>
	            <td>头像</td>
	            <td>绿竹</td>
	            <td>男</td>
	            <td>云南/昆明</td>
	            <td>2014-09-14</td>
	            <td>388</td>
	        </tr>
	        <tr>
	            <td>3</td>
	            <td>头像</td>
	            <td>绿竹</td>
	            <td>男</td>
	            <td>云南/昆明</td>
	            <td>2014-09-14</td>
	            <td>388</td>
	        </tr>
	        <tr>
	            <td>4</td>
	            <td>头像</td>
	            <td>绿竹</td>
	            <td>男</td>
	            <td>云南/昆明</td>
	            <td>2014-09-14</td>
	            <td>388</td>
	        </tr>
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
</body>
</html>