<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>联系我们</title>
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
	<div class="container content">
	    <form class="form-horizontal" role="form" style="width: 800px;max-width:100%;height: 600px;margin-left: auto;margin-right: auto">
	        <legend><h6 style="font-weight: bold">编辑联系我们</h6></legend>
	        <div class="form-group">
	            <label for="myEditor" class="col-sm-2 control-label">内容</label>
	            <div class="col-sm-10">
                	<script id="myeditor" type="text/plain" name="content"></script>
	            </div>
	        </div>
	        <div class="form-group text-center">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="button" class="btn btn-wide btn-primary mrm">提交更新</button>
	            </div>
	        </div>
	    </form>
	</div>
	<!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
	
	<!--百度编辑器-->
    <!-- <link href="/plugin/umeditor1_2_2/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/plugin/umeditor1_2_2/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugin/umeditor1_2_2/umeditor.min.js"></script>
    <script type="text/javascript" src="/plugin/umeditor1_2_2/lang/zh-cn/zh-cn.js"></script> -->
    
    <link type="text/css" rel="stylesheet" href="/plugin/ueditor1.2.3.0/themes/default/ueditor.css" />
    <script type="text/javascript" src="/plugin/ueditor1.2.3.0/editor_config_full.js"></script>
	<script type="text/javascript" src="/plugin/ueditor1.2.3.0/editor.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugin/ueditor1.2.3.0/lang/zh-cn/zh-cn.js"></script>
    
	<script src="/plugin/artDialog/dialog-min.js"></script>
	<script src="/plugin/base64.js"></script>
	<script src="/js/tips.js"></script>
    
    <!-- <script type="text/javascript" src="/js/linkUs.js"></script> -->
    
    <script type="text/javascript">
    var editor = new UE.ui.Editor();
    editor.render('myeditor');
    </script>
</body>
</html>