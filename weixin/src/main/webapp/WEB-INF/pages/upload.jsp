<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="/plugin/jquery.1.11.1-min.js"></script>
<script src="/uploadify/3.2/jquery.uploadify-3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/uploadify/3.2/uploadify.css">
<style type="text/css">
body {
	font: 13px Arial, Helvetica, Sans-serif;
}
</style>
</head>
<body>
<h1>Uploadify Demo</h1>
	<form>
		<div id="queue"></div>
		<input id="file_upload" name="file_upload" type="file" multiple="true">
	</form>

	<script type="text/javascript">
		$(function() {
			$('#file_upload').uploadify({
				'formData'     : {
					'timestamp' : '',
					'token'     : ''
				},
				'swf'      : '/uploadify/3.2/uploadify.swf',
				'uploader' : 'uploadify.php'
			});
		});
	</script>
</body>
</html>