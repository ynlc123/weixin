<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>编辑活动</title>
    <link href="/plugin/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/plugin/flat-ui/css/flat-ui.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/css/common2.css" />
    <link type="text/css" rel="stylesheet" href="/uploadify/3.1/uploadify.css">

   <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="/plugin/flat-ui/js/vendor/html5shiv.js"></script>
    <script src="/plugin/flat-ui/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <%-- 导航栏 --%>
    <%@ include file="../navbar.jsp" %>
	<div class="container content">
	    <form action="/center/activities/update.htm" method="post" class="form-horizontal" role="form" style="width: 800px;max-width:100%;margin-left: auto;margin-right: auto">
	        <input type="hidden" name="uuid" value="${activities.uuid }">
	        <legend><h6 style="font-weight: bold">编辑活动</h6></legend>
	        <div class="form-group">
	            <label for="title" class="col-sm-2 control-label">标题</label>
	            <div class="col-sm-10">
	                <input type="text" class="form-control input-sm" id="title" name="title" placeholder="输入活动标题" value="${activities.title }" maxlength="30">
	                <span class="help-block"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="myEditor" class="col-sm-2 control-label">内容</label>
	            <div class="col-sm-10">
	                <script type="text/plain" id="myEditor" name="content" style="width:650px;height:240px;">
                      <p>${activities.content}</p>
                    </script>
                    <span class="help-block" id="content-tips"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="exampleInputFile" class="col-sm-2 control-label">图片</label>
	            <div class="col-sm-10" style="padding-top: 7px;">
	                <input type="file" name="file" id="fileupload"/>
	                <div class="alert alert-danger" role="alert" style="font-size: 13px;margin-top: 5px;">支持格式:jpg/gif/jpeg/png/bmp</div>
                    <div id="fileQueue"></div>
                    <div id="upload-list">
					    <div class="uploadify-queue-item init-edit">
					    <div class="cancel"><a href="javascript:;" class="del-upload-file" data-id="${activities.image.uuid }">X</a></div>
					    <span class="fileName"><a href="">${activities.image.title }</a></span><span class="data"></span>
					    </div>
				    </div>
                    <a href="#" class="fileupload  btn_smallgreen" type="submit" style="display:none;margin-top:10px;"><span>开始上传</span></a>
	            	<span class="help-block" id="image-tips"></span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label class="col-sm-2 control-label">活动时间</label>
	            <div class="col-sm-10">
	            	<input type="text" class="form-control" id="startTime" name="startTime" style="width: 150px;display:inline;" onClick="WdatePicker()" placeholder="起始时间" value="${activities.startTime }">
	            	 至  
	            	<input type="text" class="form-control" id="endTime" name="endTime" style="width: 150px;display:inline;" onClick="WdatePicker()" placeholder="结束时间" value="${activities.endTime }">
	            	<div style="margin-top:10px;">
	            		<span class="help-block" style="width: 200px;display:inline;" id="startTime-tips"></span>
	            		<span class="help-block" style="margin-left:50px; width: 200px;display:inline;" id="endTime-tips"></span>
	            	</div>
	            </div>
	        </div>
	        <div class="form-group text-center">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="submit" class="btn btn-wide btn-primary mrm">提交保存</button>
	            </div>
	        </div>
	    </form>
	    <input type="hidden" id="jsessionid" value="<%=session.getId()%>"/>
	</div>
	
	<!--footer-->
	<%@ include file="../footer.jsp" %>
	<script src="/plugin/jquery.1.11.1-min.js"></script>
	<script src="/plugin/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="/uploadify/3.1/jquery.uploadify-3.1.min.js"></script>
	<script type="text/javascript" src="/js/upload-image.js"></script>
	
	<script type="text/javascript" src="http://uil.fanna.com.cn/my97datepicker/4.8b2/WdatePicker.js"></script>
	
	<!--百度编辑器-->
    <link href="/plugin/umeditor1_2_2/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/plugin/umeditor1_2_2/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugin/umeditor1_2_2/umeditor.min.js"></script>
    <script type="text/javascript" src="/plugin/umeditor1_2_2/lang/zh-cn/zh-cn.js"></script>
    
	<script type="text/javascript" src="/js/activities_operate.js"></script>
</body>
</html>
</body>
</html>