<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>发布求购信息-求购管理</title>
	<link type="text/css" rel="stylesheet" href="/css/common2.css" />
	<link type="text/css" rel="stylesheet" href="http://uil.fanna.com.cn/uploadify/3.1/uploadify.css">
</head>
<body>

<!--[if IE 6]>
<script type="text/javascript" src="http://uil.fanna.com.cn/DD_belatedPNG.js"></script>
<script type="text/javascript">DD_belatedPNG.fix(".applist li img");</script>
<![endif]-->
<div class="fn-clear"></div>
<div class="warpper" id="show-container">
    <div class="nav_release new_navt">
        <h3>发布求购信息</h3>
        <span class="explains">（写下您的采购需求，快速获得多个供应商报价）</span>
    </div>
    <form action="/center/provide/purchaseInfo/save.htm" method="post" id="releaseMessage-form">
    <div class="mainBox">
        <table class="tabel_list purchase_table">
            <tr class="received-box" data-index="1" id="received1">
                <td class="txtrt">图片:</td>
                <td>
                    <input type="hidden" value="" name="pictures" id="picIds"/>
	                <input type="file" name="fileupload" id="fileupload1" />
                    <div id="fileQueue1"></div>
                    <div class="small_tipBox warnBg" style="line-height:18px; margin-top:5px;">
                        <!-- <span></span> -->
    <p>上传采购产品的相关图片以便供应商进行报价，最多可上传<b class="preco">5</b>个附件，单个大小不超过<b class="preco">3M</b>
    <br/>格式为<b class="preco">jpg</b>或<b class="preco">jpeg</b>或<b class="preco">png</b>或<b class="preco">bmp</b>或<b class="preco">gif</b>。</p>
    </div>
                    <a href="#" class="fileupload1  btn_smallgreen" type="submit" style="display:none;"><span>开始上传</span></a>
                </td>
            </tr> 
            <tr class="received-box" data-index="0" id="received0">
                <td class="txtrt">附件:</td>
                <td>
                    <input type="file" name="fileupload" id="fileupload0" />
                    <div id="fileQueue0"></div>
                    <div class="small_tipBox warnBg" style="line-height:18px; margin-top:5px;">
                        <!-- <span></span> -->
    <p>上传采购产品的相关附件以便供应商进行报价，最多可上传<b class="preco">5</b>个附件，单个大小不超过<b class="preco">3M</b>
    <br/>格式为<b class="preco">rar</b>或<b class="preco">doc</b>或<b class="preco">docx</b>或<b class="preco">wps</b>或<b class="preco">txt</b>或<b class="preco">xls</b>或<b class="preco">xlsx</b>或<b class="preco">pdf</b>。</p>
    </div>
                    <a href="#" class="fileupload  btn_smallgreen" type="submit" style="display:none;"><span>开始上传</span></a>
                </td>
            </tr>
        </table>      
     </div>
    <input type="hidden" name="twoLevel" id="two-level" value="no">
   </form>
    <input type="hidden" id="loginsession" value="DB5B190F7347086F7179021D2423EDEB.worker1"/>
</div>
<script type="text/javascript" src="http://uil.fanna.com.cn/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="http://i.fanna.com.cn/uploadify/3.1/jquery.uploadify-3.1.min.js"></script>
<script type="text/javascript" src="/js/purchaseInfoInput.js?d=201311251206"></script>

</body>
</html>