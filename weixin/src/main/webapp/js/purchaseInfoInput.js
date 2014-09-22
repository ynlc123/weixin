$(function () {
	
    $("a.fileupload").click(function () {
        var uploadId = $(this).parents(".received-box").attr("data-index");
        $("#fileupload" + uploadId).uploadify('upload', '*');
        return false;
    });
    
    // 上传采购图片
    $("a.fileupload1").click(function () {
        var uploadId = $(this).parents(".received-box").attr("data-index");
        $("#fileupload" + uploadId).uploadify('upload', '*');
        return false;
    });
});

//  页面中附件上传
$('#fileupload0').uploadify({
    swf: '/uploadify/3.1/uploadify.swf',
    uploader: '/center/attachment/upload.htm',
    formData: {'jsessionid': $("#loginsession").val()},
    buttonClass: 'some-class',
    queueID: "fileQueue0", //和存放队列的DIV的id一致
    debug: false,//debug模式开/关，打开后会显示debug时的信息
    fileObjName: 'uploadFile',//上传的文件
    progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
    auto: false, //是否自动开始
    multi: true, //是否支持多文件上传
    buttonText: 'Browse', //按钮上的文字
    method: 'post',
    uploadLimit: 5, //一次同步上传的文件数目
    fileSizeLimit: 30720, //设置单个文件大小限制
    queueSizeLimit: 5, //队列中同时存在的文件个数限制
    fileTypeDesc: '支持格式:rar/doc/docx/wps/txt/xls/xlsx/pdf', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
    fileTypeExts: '*.rar;*.doc;*.docx;*.docx;*.wps;*.txt;*.xls;*.xlsx;*.pdf',//允许的格式
    onUploadError: function (file, errorCode, errorMsg, errorString) {
        if ($('#fileQueue0').find(".init-edit:visible").size() == 0) {
            $("#received0").find("a.fileupload").hide();
        }
    },
    onSelect: function (queueData) {
        $("#received0").find("a.fileupload").show();
    }
});

function uploadInitAttach(fileId, queueId, pId) {
    var _s = $("#" + queueId).find(".init-edit:visible").size();
    $("#" + fileId).uploadify('destroy');
    $("#" + fileId).uploadify({
        swf: '/uploadify/3.1/uploadify.swf',
        uploader: '/center/attachment/upload.htm',
        formData: {'jsessionid': $("#loginsession").val()},
        buttonClass: 'some-class',
        queueID: queueId, //和存放队列的DIV的id一致
        debug: false,//debug模式开/关，打开后会显示debug时的信息
        fileObjName: 'uploadFile',//上传的文件
        progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
        auto: false, //是否自动开始
        multi: true, //是否支持多文件上传
        buttonText: 'Browse', //按钮上的文字
        method: 'post',
        uploadLimit: (5 - _s), //一次同步上传的文件数目
        fileSizeLimit: 30720, //设置单个文件大小限制
        queueSizeLimit: (5 - _s), //队列中同时存在的文件个数限制
        fileTypeDesc: '支持格式:rar/doc/docx/wps/txt/xls/xlsx/pdf', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
        fileTypeExts: '*.rar;*.doc;*.docx;*.docx;*.wps;*.txt;*.xls;*.xlsx;*.pdf',//允许的格式
        onUploadError: function (file, errorCode, errorMsg, errorString) {
            if ($('#' + queueId).find(".init-edit:visible").size() == 0) {
                $("#" + pId).find("a.fileupload").hide();
            }
        },
        onSelect: function (queueData) {
            $("#" + pId).find("a.fileupload").show();
        }
    });
}

//页面中图片上传
$('#fileupload1').uploadify({
    swf: '/uploadify/3.1/uploadify.swf',
    uploader: '/center/upload/image/insert.htm',
    formData: {'jsessionid': $("#loginsession").val()},
    buttonClass: 'some-class',
    queueID: "fileQueue1", //和存放队列的DIV的id一致
    debug: false,//debug模式开/关，打开后会显示debug时的信息
    fileObjName: 'uploadFile',//上传的文件
    progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
    auto: false, //是否自动开始
    multi: true, //是否支持多文件上传
    buttonText: 'Browse', //按钮上的文字
    method: 'post',
    uploadLimit: 5, //一次同步上传的文件数目
    fileSizeLimit: 30720, //设置单个文件大小限制
    queueSizeLimit: 5, //队列中同时存在的文件个数限制
    fileTypeDesc: '支持格式:jpg/gif/jpeg/png/bmp', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
    fileTypeExts: '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
    onUploadError: function (file, errorCode, errorMsg, errorString) {
        if ($('#fileQueue1').find(".init-edit:visible").size() == 0) {
            $("#received1").find("a.fileupload1").hide();
        }
    },
    onSelect: function (queueData) {
        $("#received1").find("a.fileupload1").show();
    }
});

function uploadInitImg(fileId, queueId, pId) {
    var _s = $("#" + queueId).find(".init-edit:visible").size();
    $("#" + fileId).uploadify('destroy');
    $("#" + fileId).uploadify({
        swf: '/uploadify/3.1/uploadify.swf',
        uploader: '/center/upload/image/insert.htm',
        formData: {'jsessionid': $("#loginsession").val()},
        buttonClass: 'some-class',
        queueID: queueId, //和存放队列的DIV的id一致
        debug: false,//debug模式开/关，打开后会显示debug时的信息
        fileObjName: 'uploadFile',//上传的文件
        progressData: 'percentage', // 'percentage''speed''all'//队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度
        auto: false, //是否自动开始
        multi: true, //是否支持多文件上传
        buttonText: 'Browse', //按钮上的文字
        method: 'post',
        uploadLimit: (5 - _s), //一次同步上传的文件数目
        fileSizeLimit: 30720, //设置单个文件大小限制
        queueSizeLimit: (5 - _s), //队列中同时存在的文件个数限制
        fileTypeDesc: '支持格式:jpg/gif/jpeg/png/bmp', //如果配置了以下的'fileExt'属性，那么这个属性是必须的
        fileTypeExts: '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式
        onUploadError: function (file, errorCode, errorMsg, errorString) {
            if ($('#' + queueId).find(".init-edit:visible").size() == 0) {
                $("#" + pId).find("a.fileupload").hide();
            }
        },
        onSelect: function (queueData) {
            $("#" + pId).find("a.fileupload1").show();
        }
    });
}

