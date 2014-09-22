<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="up_picturebox" >
    <span class="infotips"></span>
    <div class="selectstyle">
        <ul>
            <li class="current">本地上传</li>
            <li>我的相册</li>
            <li>网络图片</li>
        </ul>
        <span>请选择图片来源</span>
        <a href="/center/album/list.htm" target="_blank">相册管理</a>
    </div>
    <div class="picturebox" id="selectpicture">
        <p class="up_info">提示：您可以上传3张图片，选择的图片单张大小不超过5MB，支持jpg,jpeg,gif,bmp,png。 <a href="/center/album/list.htm" target="_blank">[新建相册]</a></p>
        <div class="selectalbum">
             <select class="default_pic_select iselect">
                <c:if test="${not empty personalAlbums }">
	            <optgroup label="私有相册：">
	                <c:forEach items="${personalAlbums }" var="album">
	                <option value="${album.id }">${album.name }</option>
	                </c:forEach>
	            </optgroup>
	            </c:if>
	            <c:if test="${not empty memberAlbums }">
	            <optgroup label="会员可见相册：">
	                <c:forEach items="${memberAlbums }" var="album">
	                <option value="${album.id }">${album.name }</option>
	                </c:forEach>
	            </optgroup>
	            </c:if>
	            <c:if test="${not empty openAlbums }">
	            <optgroup label="公开相册：">
	                <c:forEach items="${openAlbums }" var="album">
	                <option value="${album.id }">${album.name }</option>
	                </c:forEach>
	            </optgroup>
	            </c:if>
            	</select>
            <a class="uploadbtn disabled" href="javascript:void(0);" id="select-muti-disabled" style="display:none;">从电脑中选择图片<i>(可多选)</i></a>
            <input type="file" name="uploadFile" id="uploadFile" style="margin-top:15px" />
            <div class="pictureset">
                <input type="checkbox" class="watermark" id="watermark" /> <label for="watermark" >添加图片水印</label>
                <a href="/center/album/watermark.htm?leftMenu=wartermark" target="_blank">水印设置</a>
            </div>
        </div>
    </div>
    <div class="picturebox" id="uploadpicture">
        <p class="albums">
        <select class="select_album iselect">
            <c:if test="${not empty personalAlbums }">
            <optgroup label="私有相册：">
                <c:forEach items="${personalAlbums }" var="album">
                <option value="${album.id }">${album.name }</option>
                </c:forEach>
            </optgroup>
            </c:if>
            <c:if test="${not empty memberAlbums }">
            <optgroup label="会员可见相册：">
                <c:forEach items="${memberAlbums }" var="album">
                <option value="${album.id }">${album.name }</option>
                </c:forEach>
            </optgroup>
            </c:if>
            <c:if test="${not empty openAlbums }">
            <optgroup label="公开相册：">
                <c:forEach items="${openAlbums }" var="album">
                <option value="${album.id }">${album.name }</option>
                </c:forEach>
            </optgroup>
            </c:if>
        </select>
            <span>请从您选择的相册中点击选择图片</span>
        </p>
        <dl class="picturelist"></dl>
        <ul class="page"></ul>
    </div>
    <style>
    </style>
    <div class="picturebox"  id="networkpicture">
        <div class="pictureurl">
            <input type="text" id="web-img-url" placeholder="请勿盗链别人的图片，防止引起纠纷！图片地址以http://开头" value="" />
            <a href="#" class="getpicurl">预览</a>
            <span style="display: none"></span>
            <div class="netpicviewbox fn-hide">
                <p>图片预览区域</p>
                <a class="picview" href="" target="blank"><img src="" /></a>                
                <div class="saveasbox">
                	<b>保存到：</b>
			        <select class="net_pic_select iselect"  style="display:block;">
			                <c:if test="${not empty personalAlbums }">
				            <optgroup label="私有相册：">
				                <c:forEach items="${personalAlbums }" var="album">
				                <option value="${album.id }">${album.name }</option>
				                </c:forEach>
				            </optgroup>
				            </c:if>
				            <c:if test="${not empty memberAlbums }">
				            <optgroup label="会员可见相册：">
				                <c:forEach items="${memberAlbums }" var="album">
				                <option value="${album.id }">${album.name }</option>
				                </c:forEach>
				            </optgroup>
				            </c:if>
				            <c:if test="${not empty openAlbums }">
				            <optgroup label="公开相册：">
				                <c:forEach items="${openAlbums }" var="album">
				                <option value="${album.id }">${album.name }</option>
				                </c:forEach>
				            </optgroup>
				            </c:if>
			        </select>
			        <a href="javascript:;" class="selectpic">使用该图片</a> 
                </div>                
            </div>
        </div>
    </div>
    <p class="picture_info">已选择的图片 <i>(已选择的图片可通过拖拽调整图片的顺序)</i></p>
    <dl class="pictureview"></dl>
</div>
<input type="hidden" id="loginsession" value="<%=session.getId()%>"/>
    <script type="text/javascript">
    //html5 placeholder
    $(function(){
    	$("#search-text").placeholder();
    });
    </script>