$(function () {
    $("a.fileupload").click(function () {
        $('#fileupload').uploadify('upload', '*');
        return false;
    });
    $("a.fileuploadcancel").click(function () {
        $('#fileupload').uploadify('cancel', '*');
    });
});
$(function () {
    /**
     * 页面中附件上传
     */
    $("#identityPath").val("");
    $("#fileupload").uploadify({
        id: jQuery(this).attr('id'),
        swf: '/uploadify/3.1/uploadify.swf',
        uploader: '/center/attachment/upload.htm',
        formData: {'jsessionid': $("#loginsession").val()},
        buttonClass: 'some-class',
        queueID: 'fileQueue', //和存放队列的DIV的id一致
        debug: false,//debug模式开/关，打开后会显示debug时的信息
        fileObjName: 'uploadFile',//上传的文件
        progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
        auto: false, //是否自动开始
        multi: true, //是否支持多文件上传
        buttonText: 'Browse', //按钮上的文字
        method: 'post',
        uploadLimit: 5, //一次同步上传的文件数目
        fileSizeLimit: 49871202, //设置单个文件大小限制
        queueSizeLimit: 5, //队列中同时存在的文件个数限制
        fileTypeDesc: '支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
        fileTypeExts: '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
        onUploadError: function (file, errorCode, errorMsg, errorString) {
            alert("文件： " + file.name + "上传失败:" + errorString);
        },
        onCancel: function (file) {
            alert("取消了： " + file.name);
        }
    });
});

function uploadInit(){
    var _s=$(".init-edit:visible").size();
    $("#fileupload").uploadify({
        id: jQuery(this).attr('id'),
        swf: '/uploadify/3.1/uploadify.swf',
        uploader: '/center/attachment/upload.htm',
        formData: {'jsessionid': $("#loginsession").val()},
        buttonClass: 'some-class',
        queueID: 'fileQueue', //和存放队列的DIV的id一致
        debug: false,//debug模式开/关，打开后会显示debug时的信息
        fileObjName: 'uploadFile',//上传的文件
        progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
        auto: false, //是否自动开始
        multi: true, //是否支持多文件上传
        buttonText: 'Browse', //按钮上的文字
        method: 'post',
        uploadLimit:(5-_s) , //一次同步上传的文件数目
        fileSizeLimit: 49871202, //设置单个文件大小限制
        queueSizeLimit: (5-_s), //队列中同时存在的文件个数限制
        fileTypeDesc: '支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
        fileTypeExts: '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
        onUploadError: function (file, errorCode, errorMsg, errorString) {
            alert("文件： " + file.name + "上传失败:" + errorString);
        },
        onCancel: function (file) {
            alert("取消了： " + file.name);
        }
    });
}
