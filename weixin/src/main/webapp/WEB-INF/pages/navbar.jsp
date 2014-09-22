<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <nav class="navbar navbar-inverse navbar-embossed" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">米戈网</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">首页</a></li>
                    <li><a href="#">产品介绍</a></li>
                    <li><a href="#">成功案例</a></li>
                    <li><a href="#">关于我们</a></li>
                    <c:if test="${not empty loginCustomer }">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的米戈 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                        	<li><a href="/center/customer/edit.htm">我的资料</a></li>
                            <li><a href="/center/customer/edit_password.htm">修改密码</a></li>
                            <li class="divider"></li>
                            <li><a href="/center/platform.htm">公众号设置</a></li>
                            <li><a href="/center/defReplyMsg.htm">设置默认自动回复内容</a></li>
                            <li><a href="/center/autoReplyArticle/list.htm">管理自动回复</a></li>
                            <li><a href="/center/autoReplyArticle/new.htm">新增自动回复</a></li>
                            <li class="divider"></li>
                            <li><a href="/center/article/addui.htm">新增文章</a></li>
                            <li><a href="/center/article/list.htm">文章列表</a></li>
                            <li class="divider"></li>
                            <li><a href="/center/activities/addui.htm">添加活动</a></li>
                            <li><a href="/center/activities/list.htm">活动列表</a></li>
                            <li><a href="/center/companyProfile.htm">公司介绍</a></li>
                            <li><a href="/center/linkus.htm">联系我们</a></li>
                            <li class="divider"></li>
                            <li><a href="/center/fans/list.htm">管理粉丝</a></li>
                            <li><a href="/center/image/list.htm">管理图片</a></li>
                        </ul>
                    </li>
                    </c:if>
                </ul>
                <ul class="nav navbar-nav navbar-right" style="margin-right: 20px;">
                    <c:if test="${empty loginCustomer }">
                    <li><a href="/login.htm">登录</a></li>
                    <li><a href="/register.htm">注册</a></li>
                    </c:if>
                    <c:if test="${not empty loginCustomer }">
                    <li><a href="#">${loginCustomer.name }</a></li>
                    <li><a href="/logout.htm">退出</a></li>
                    </c:if>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>