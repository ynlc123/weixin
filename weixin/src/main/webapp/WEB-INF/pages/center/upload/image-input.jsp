<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>上传图片</title>
	<link rel="shortcut icon" href="http://picture.fanna.com.cn/favicon.ico" />
	<link type="text/css" rel="stylesheet" href="http://uic.fanna.com.cn/base.css" />
	<link type="text/css" rel="stylesheet" href="http://uil.fanna.com.cn/uploadify/3.1/uploadify.css" />
	<link type="text/css" rel="stylesheet" href="http://uip.fanna.com.cn/pictureinto/base/pictureinto.css" />
</head>
<body>
	<script type="text/javascript" src="http://uil.fanna.com.cn/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="http://uil.fanna.com.cn/uploadify/3.1/jquery.uploadify-3.1.js"></script>
	<script type="text/javascript" src="http://uil.fanna.com.cn/jqueryui/jquery-ui-1.8.20.custom.min.js"></script>
	<script type="text/javascript" src="http://uil.fanna.com.cn/artdialog/5.0.1/artDialog.js"></script>
	<script type="text/javascript" src="http://uip.fanna.com.cn/pictureinto/other/page.js"></script>
	
	<script type="text/javascript">
	    $.getScript("/pictureinto/base/pictureinsert-1.0.js",jsSuccess);
	    function jsSuccess(data,textStatus){
	        $.ajax({url:"/center/image/uploadUI.htm",success:picSuccess,dataType:"html"});
	        function picSuccess(data){
	            art.dialog({width:750,height:480,padding:0,title:'插入图片',content:data,lock:true,fixed: true});
	            var insertPicSetting=({
	                selectStyle:3,                        //默认选择方式，number型，1：从相册中选择；2：本地上传；3：选择网络图片
	                maxNumber:5,                          //允许上传的最大数量，number型，取值范围：0-10
	                defaultAlbum:2,                      //默认选中的相册，number型  0:用户选择； 1：装修相册；2:公司相册
	                isWatermark:true,                    //是否添加水印，boolean型，可选值：true|false
	                insertbtnValue:"插入图片",          //"插入图片"按钮的值
	                cancelbtnShow:true,                 //是否显示取消按钮
	                fileObjName:"dfa",
	                pictureType:"jpg,jpeg,png,gif",   //允许上传的图片类型，string型
	                uploadURL:"/upload/album/"         //图片存放路径，string型
	            });
	            insertPicture(insertPicSetting);
	       }}
	</script>
	<input type="hidden" id="loginsession" value="<%=session.getId()%>"/>
</body>
</html>