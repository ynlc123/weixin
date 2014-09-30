$(function () {
    // 上传采购图片
    $("a.fileupload").click(function () {
    	$("#fileupload").uploadify('upload', '*');
        return false;
    });
});

//页面中图片上传
$('#fileupload').uploadify({
    swf: '/uploadify/3.1/uploadify.swf',
    uploader: '/uploadFile.htm',
    formData: {'jsessionid': $("#jsessionid").val()},
    buttonClass: 'some-class',
    queueID: "fileQueue", //和存放队列的DIV的id一致
    debug: false,//debug模式开/关，打开后会显示debug时的信息
    fileObjName: 'file',//上传的文件
    progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
    auto: false, //是否自动开始
    multi: false, //是否支持多文件上传
    buttonText: 'Browse', //按钮上的文字
    method: 'post',
    uploadLimit: 1, //一次同步上传的文件数目
    fileSizeLimit: 30720, //设置单个文件大小限制
    queueSizeLimit: 1, //队列中同时存在的文件个数限制
    fileTypeDesc: '支持格式:jpg/gif/jpeg/png/bmp', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
    fileTypeExts: '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
    onUploadError: function (file, errorCode, errorMsg, errorString) {
        if ($('#fileQueue').find(".init-edit:visible").size() == 0) {
            $("a.fileupload").hide();
        }
    },
    onSelect: function (queueData) {
        $("a.fileupload").show();
    }
});

