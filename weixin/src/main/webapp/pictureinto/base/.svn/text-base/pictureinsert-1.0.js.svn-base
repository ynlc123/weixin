//flash插件初始化
var initFlash = function () {
    var notLens = $('dl.pictureview dd.notsortable').size();
    var optionVal = $('select.default_pic_select option:selected').attr("value");
    var watermark = false;
    if ($('.watermark').attr('checked') == 'checked') {
        watermark = true;
    }
    var initSets = {
        'swf': '/uploadify/3.2/uploadify.swf',
        'uploader': '/center/upload/image/insert.htm;jsessionid='+$("#loginsession").val()+'?albumId=' + optionVal + '&watermark=' + watermark,
        'formData': {},
        'auto': true,
        'fileObjName': 'uploadFile',
        'buttonClass': "uploadbtn",
        'multi': true,
        'fileSizeLimit': '5120KB',
        'fileTypeExts': '*.gif; *.jpg; *.png',
        uploadLimit: notLens,
        queueSizeLimit: notLens,
        'buttonCursor': 'arrow',
        removeCompleted: true,
        buttonClass: 'uploadbtn',
        width: 237,
        height: 39,
        buttonText: '从电脑中选择图片(可多选)'
    }
    $('#uploadFile').show();
    $('#select-muti-disabled').hide();
    $('#uploadFile').uploadify('destroy');
    $('#uploadFile').uploadify(initSets);
}

//flash上传按扭disabled
function disabledFalsh() {
    $('#uploadFile').hide();
    $('#select-muti-disabled').show();
}
//flash上传按扭disabled
function disabledFalshBackground() {
    var notLens = $('dl.pictureview dd.uploading').size();
    var comLens = $('dl.pictureview dd.complete').size();
    var dLens = $('dl.pictureview dd').size();
    if (parseInt(dLens) == parseInt(comLens)) {
        $('.uploadify').hide();
        $('#select-muti-disabled').show();
    }
}
//提示信息调用方法
function messageInfo(info) {
    $("span.infotips").html(info).css("marginLeft", (620 - $("span.infotips").width()) / 2).show();
    setTimeout(function () {
        $("span.infotips").fadeOut();
    }, 3000);
}
//图片序号
function picNum() {
    $("dl.pictureview dd.notsortable").html(
        function () {
            var picBoxNums = $(this).index() + 1;
            return picBoxNums;
        }
    );
}
function delImg() {
    //删除图片
    //$("dl.pictureview dd.complete img").before('<a class="del" href="#"></a>');
    $("dl.pictureview dd.complete a.del").die().live('click', function () {
        var thisIndex = $(this).parents('dd').attr('seq');
        var pictureviewLen = $('dl.picturelist dd').size();
        for (var i = 0; i < pictureviewLen; i++) {
            var dlIndex = $('dl.picturelist dd').eq(i).attr('seq');
            if (thisIndex == dlIndex) {
                $('dl.picturelist dd').eq(i).removeAttr("class").find('b').remove();
            }
        }
        $(this).parent().remove();
        $("dl.pictureview").append("<dd class='notsortable'></dd>").fadeIn();
        picNum();
        initFlash();
        return false;
    });
}
function delUploadImg() {
    //删除图片
    $("dl.pictureview dd.complete img").before('<a class="del" href="javascript:;"></a>');
    $("dl.pictureview dd.complete a.del").click(function () {
        var thisIndex = $(this).siblings("img").attr('index');
        var pictureviewLen = $('dl.picturelist dd').size();
        for (var i = 0; i < pictureviewLen; i++) {
            var dlIndex = $('dl.picturelist dd').eq(i).find('img').attr('index');
            if (thisIndex == dlIndex) {
                $('dl.picturelist dd').eq(i).removeAttr("class").find('b').remove();
            }
        }
        $(this).parent().remove();
        $("dl.pictureview").append("<dd class='notsortable'></dd>").fadeIn();
        var notLens = $('dl.pictureview dd.notsortable').size();
        if (notLens == 0) {
            $('#file_upload').uploadify('disable', true);
        }
        else {
            initFlash();
        }
        picNum();
    });
}
function getError(XMLHttpRequest, textStatus, errorThrown) {
    messageInfo("数据获取异常，请重新获取！！！");
}
function data_display(sets, datas) {
    var str_list = "";
    $.each(datas, function (i) {
        str_list += '<dd seq="' + datas[i].id + '"><a href="#" class="imgBox"><img src="' + datas[i].path + '"/></a></dd>'
    });
    $('.picturelist').empty();
    $('.' + sets.containClass).append(str_list);
    //从相册中选择图片
    $("dl.picturelist dd").die().live('click', function () {
        var imgIn = $(this).attr("seq");
        //已选择图片个数
        if ($(this).hasClass('current')) {
            var notLen = $('dl.pictureview dd.complete').size();
            for (var i = 0; i < notLen; i++) {
                if ($('dl.pictureview dd.complete').eq(i).attr('seq') == imgIn) {
                    $('dl.pictureview dd.complete').eq(i).removeClass('complete').addClass('notsortable').removeAttr('seq').html(i + 1);
                }
            }
            $(this).removeClass("current").find("b").remove();
            initFlash();
        }
        else {
            var notsortableLen = $('dl.pictureview dd.notsortable').size();
            var countLen = $('dl.pictureview dd').size();
            if (notsortableLen > 0 && notsortableLen <= countLen) {
                var isFlag = false;
                var thisCurrentId = $(this).attr('seq');
                var isIdCurrent = function (thisCurrentId) {
                    var flag = false;
                    for (var i = 0, len = $('dl dd.complete').size(); i < len; i++) {
                        if ($('dl dd.complete').eq(i).attr('seq') == thisCurrentId) {
                            flag = true;
                        }
                    }
                    return flag;

                }
                isFlag = isIdCurrent(thisCurrentId);
                if (isFlag) {
                    $(this).addClass("current").find("img").parents(".imgBox").before("<b></b>");
                }
                else {
                    $(this).addClass("current").find("img").parents(".imgBox").before("<b></b>");
                    var imgSrc = $(this).find('img').attr("src");
                    $('dl.pictureview dd.notsortable').eq(0).attr("class", "haspicture complete").attr('seq', imgIn).html('<a class="del" href="#"></a><a href="#" class="imgBox"><img src="' + imgSrc + '"/></a>');
                    //删除图片
                    delImg();
                    initFlash();
                    var mLen = $('dl.pictureview dd.notsortable').size();
                    if (mLen == 0) {
                        disabledFalsh();
                    }
                }
            }
            else {
                var isFlag = false;
                var thisCurrentId = $(this).attr('seq');
                var isIdCurrent = function (thisCurrentId) {
                    var flag = false;
                    for (var i = 0, len = $('dl dd.complete').size(); i < len; i++) {
                        if ($('dl dd.complete').eq(i).attr('seq') == thisCurrentId) {
                            flag = true;
                        }
                    }
                    return flag;

                }
                isFlag = isIdCurrent(thisCurrentId);
                if (isFlag) {
                    $(this).addClass("current").find("img").parents(".imgBox").before("<b></b>");
                } else {
                    messageInfo("已选择图片位置已满!!!");
                    disabledFalsh();
                }
            }
        }
        return false;
    });
}
function insertPicture(objset) {
//加载默认相册的数据
    var optionVal = $('.select_album option:selected').attr("value");
    var def_set = default_page_set;
    def_set.param_list = optionVal;
    def_set.page_name = '/center/upload/image/getPicsByAlbum.htm';
    def_set.datadisplay = data_display;
    def_set.getError = getError;
    def_set.items_per_page = 16,
        fan_pager(def_set);
    var defaultSetting = ({
        selectStyle: objset.selectStyle,                       //默认选择方式，number型，1：从相册中选择；2：本地上传；3：选择网络图片
        maxNumber: objset.maxNumber,                           //允许上传的最大数量，number型，取值范围：0-10
        defaultAlbum: objset.defaultAlbum,                    //默认选中的相册，number型  0:用户选择； 1：装修相册；2:公司相册
        isWatermark: objset.isWatermark,                      //是否添加水印，boolean型，可选值：true|false
        insertbtnValue: objset.insertbtnValue,               //"插入图片"按钮的值
        cancelbtnShow: objset.cancelbtnShow,                 //是否显示取消按钮
        pictureType: objset.pictureType,                      //允许上传的图片类型，string型
        uploadURL: objset.uploadURL,                           //图片存放路径，string型
        customImages: objset.customImages
    });
    var albumId = $('.default_pic_select  option:selected').val();
    var watermark = false;
    if ($('.watermark').attr('checked') == 'checked') {
        watermark = true;
    }
    var sets = {
        'swf': '/uploadify/3.2/uploadify.swf',
        'uploader': '/center/upload/image/insert.htm;jsessionid='+$("#loginsession").val()+'?albumId=' + albumId + '&watermark=' + watermark,
        'formData': {},
        'auto': true,
        'fileObjName': 'uploadFile',
        'buttonClass': "uploadbtn",
        'multi': true,
        'fileSizeLimit': '5120KB',
        'fileTypeExts': '*.gif; *.jpg; *.png',
        //uploadLimit:5,           $('dl.pictureview dd.notsortable').size()
        uploadLimit: defaultSetting.maxNumber,
//	    	 	uploadLimit:$('dl.pictureview dd.notsortable').size(),
        'buttonCursor': 'arrow',
        //queueSizeLimit:5,
        queueSizeLimit: defaultSetting.maxNumber,
//	    	    queueSizeLimit:$('dl.pictureview dd.notsortable').size(),
        removeCompleted: true,
        buttonClass: 'uploadbtn',
        width: 237,
        height: 39,
        buttonText: '从电脑中选择图片(可多选)'

    }
    $('#uploadFile').uploadify(sets);
    $('.select_album').change(function () {
        var optionVal = $('.select_album option:selected').attr("value");
        var def_set = default_page_set;
        def_set.param_list = optionVal;
        def_set.getError = getError;
        def_set.items_per_page = 16;
        def_set.pageNo = 1;
        def_set.current_page = 1;
        def_set.page_name = '/center/upload/image/getPicsByAlbum.htm';
        def_set.datadisplay = data_display;
        fan_pager(def_set);
    });
    // $('select.default_pic_select').click(function(){
    // var albumId=$('.default_pic_select  option:selected').val();
    //    console.log("adsf"+albumId);
    // if($('.watermark').attr('checked')=='checked'){
    // 	watermark=true;
    // }
    // var strUrl='/center/upload/image/insert.htm;jsessionid='+$("#loginsession").val()+'?albumId='+albumId+'&watermark='+watermark;
    // 	$("#uploadFile").uploadify('settings','uploader', strUrl);
    // });
    // $('.watermark').click(function(){
    // var albumId=$('.default_pic_select  option:selected').val();
    //    console.log(albumId);
    // if($('.watermark').attr('checked')=='checked'){
    // 	watermark=true;
    // }
    // var strUrl='/center/upload/image/insert.htm;jsessionid='+$("#loginsession").val()+'?albumId='+albumId+'&watermark='+watermark;
    // 	$("#uploadFile").uploadify('settings','uploader', strUrl);
    // });
    //从相册中选择图片
    $("dl.picturelist dd").die().live('click', function () {
        var imgIn = $(this).attr("seq");
        //已选择图片个数
        if ($(this).hasClass('current')) {
            var notLen = $('dl.pictureview dd.complete').size();
            for (var i = 0; i < notLen; i++) {
                if ($('dl.pictureview dd.complete').eq(i).attr('seq') == imgIn) {
                    $('dl.pictureview dd.complete').eq(i).removeClass('complete').addClass('notsortable').removeAttr('seq').html(i + 1);
                }
            }
            $(this).removeClass("current").find("b").remove();
            initFlash();
        }
        else {
            var notsortableLen = $('dl.pictureview dd.notsortable').size();
            var countLen = $('dl.pictureview dd').size();
            if (notsortableLen > 0 && notsortableLen <= countLen) {
                $(this).addClass("current").find("img").parents(".imgBox").before("<b></b>");
                var imgSrc = $(this).find('img').attr("src");
                $('dl.pictureview dd.notsortable').eq(0).attr("class", "haspicture complete").attr('seq', imgIn).html('<a class="del" href="#"></a><a href="#" class="imgBox"><img src="' + imgSrc + '"/></a>');
                //删除图片
                delImg();
                initFlash();
                var mLen = $('dl.pictureview dd.notsortable').size();
                if (mLen == 0) {
                    disabledFalsh();
                }
            }
            else {
                messageInfo("已选择图片位置已满!!!");
                disabledFalsh();
            }
        }
        return false;
    });


    //插入方式选择
    $(".selectstyle ul li").click(function () {
        $(".selectstyle ul li").removeClass("current");
        $(this).addClass("current").siblings("li").removeClass("current");
        $(".picturebox").eq($(this).index()).fadeIn().siblings(".picturebox").hide();
    });
    //默认插入方式
    //    $(".selectstyle ul li").eq(defaultSetting.selectStyle-1).click();
    //    for(var i=0;i<$(".selectstyle ul li").size();i++){
    //        var inx=defaultSetting.selectStyle-1;
    //        if(i==inx){
    //            $(".selectstyle ul li").eq(inx).addClass("current").siblings("li").removeClass("current");
    //            $(".picturebox").eq(inx).fadeIn().siblings(".picturebox").hide();
    //        }
    //    }
    //“选择相册”的select容器
    //$(".select_album").iSimulateSelectUpload();
    //$(".iselect").iSimulateSelect();

    //水印设置
    /*if(defaultSetting.isWatermark=true){
     $(".pictureset input.watermark").attr("disabled","disabled");
     $(".pictureset label").html("当前相册不允许添加水印");
     }*/
    //选择默认上传相册
    for (var i = 0; i < $("select.iselect option").size(); i++) {
        var albumIndex = $("select.iselect option").eq(i).attr('albumIndex');
        if (albumIndex != 'undefined' && albumIndex == defaultSetting.defaultAlbum) {
            $("select.iselect option").eq(i).attr("selected", "selected");
        }
    }
    $(".i_currentselected").html($("select.iselect").find("option:selected").text());
    //输出图片预览容器
    for (var i = 0; i < defaultSetting.maxNumber; i++) {
        $("dl.pictureview").append("<dd class='notsortable'></dd>");
        picNum();
    }
    //显示已上传的图片
    for (var i = 0, len = defaultSetting.customImages.length; i < len; i++) {
        var image = defaultSetting.customImages[i];
        $('dl.pictureview dd.notsortable').eq(0).attr("class", "haspicture complete").attr('seq', image.id).html('<a class="del" href="#"></a><a href="#" class="imgBox"><img src="' + image.url + '"/></a>');
    }
    disabledFalshBackground();
    //删除图片
    delImg();
    /*    //从相册中选择图片
     $("dl.picturelist dd").toggle(function(){
     $(this).addClass("current").find("img").before("<b></b>");
     },function(){
     $(this).removeClass("current").find("b").remove();
     });*/
    //网络图片
    $(".pictureurl input").click(function () {
        $(this).select();
    });
    /* 用于验证图片扩展名的正则表达式 */
    function checkFilesExName(str) {
        var strRegex = "(.jpg|.JPG|.PNG|.png|.gif|.GIF|.jpeg|.JPEG)$";
        var re = new RegExp(strRegex);
        if (re.test(str.toLowerCase())) {
            return true;
        }
        else {
            return false;
        }
    }

    $('a.getpicurl').click(function () {
        $('.netpicviewbox').addClass('fn-hide');
        var picTxt = $('.pictureurl input[type="text"]').val();
        var Img = new Image();
        Img.onload = function () {
            $(".pictureurl span").html("图片正在预览中...").fadeIn();
            $('.netpicviewbox').removeClass('fn-hide').children('a').attr('href', picTxt).children('img').attr('src', picTxt);
            $(".pictureurl span").fadeOut(5000);
        }
        Img.onerror = function () {
            $(".pictureurl span").fadeOut(5000);
            messageInfo("输入的图片地址有误!请确保图片地址以http://开头");
        }
        Img.src = picTxt;
        return false;
    });

    // 使用网络图片函数
    function getPicUrl() {
        var iThis = $(this);
        var comlen = $('dl.pictureview dd.complete').size();
        var urltxt = $("a.picview img").attr('src');
        var notLen = $('dl.pictureview dd.notsortable').size();
        if (notLen == 0) {
            $(".pictureurl span").html("添加图片位置已满！").show();
            setTimeout(function () {
                $(".pictureurl span").fadeOut(500);
            }, 4000)

        }
        else {
            function success(data, textStatus) {
                if (data.resultInfo.isSuccess == true) {
                    $('dl.pictureview dd.notsortable').eq(0).attr("class", "haspicture complete").attr('seq', data.resultInfo.id).html('<a class="del" href="#"></a><a href="#" class="imgBox"><img src="' + data.resultInfo.imgUrl + '"/></a>');
                    $('.netpicviewbox').addClass('fn-hide').children('a').attr('href', "").children('img').attr('src', "");
                    $('.pictureurl input[type="text"]').val('http://');
                    var mLen = $('dl.pictureview dd.notsortable').size();
                    initFlash();
                    if (mLen == 0) {
                        disabledFalsh();
                    }

                    // 删除图片
                    delImg();
                    iThis.on('click', getPicUrl);
                    $(".pictureurl span").html("图像应用成功").fadeIn();
                    $(".pictureurl span").fadeOut(5000);
                } else {
                    iThis.on('click', getPicUrl);
                    $(".pictureurl span").html("系统繁忙，操作失败").fadeIn();
                    $(".pictureurl span").fadeOut(5000);
                }
            }

            var albumId = $('.net_pic_select option:checked').val();
            $.ajax({url: "/center/upload/image/insertWebPic.htm", data: {albumId: albumId, webpicPath: urltxt}, dataType: "json", type: "post",
                beforeSend: function (XHR) {
                    iThis.off('click');
                    $(".pictureurl span").html("数据正在加载中...").fadeIn();
                },
                success: success,
                error: function (data, textStatus) {
                    iThis.on('click', getPicUrl);
                    $(".pictureurl span").html("系统繁忙，操作失败").fadeIn();
                    $(".pictureurl span").fadeOut(5000);
                }
            });
        }
        return false;
    }

    $(".netpicviewbox a.selectpic").on("click", getPicUrl);
    var pictureurl = $(".pictureurl input").val();
    $(".pictureurl input").focus(function () {
        if ($(this).val() == pictureurl) {
            $(this).val("");
        }
    }).blur(function () {
            if ($(this).val() == "") {
                $(this).val(pictureurl);
            }
        });
    //已选择的图片Demo
//    $("dl.pictureview dd:eq(0)").attr("class","haspicture complete").html("").append('<img src="http://pic3.zhongsou.com/image/3812f22e0aff45ef559.jpg" />');
    //删除图片
    /*    $("dl.pictureview dd.complete img").before('<a class="del" href="javascript:;"></a>');
     $("dl.pictureview dd.complete a.del").click(function(){
     $(this).parent().remove();
     $("dl.pictureview").append("<dd class='notsortable'></dd>").fadeIn();
     picNum();
     });*/
    //图片上传中
//    $("dl.pictureview dd:eq(1)").attr("class","haspicture uploading").html("<i>37%</i>");
    //已选择的图片拖拽排序
    $("dl.pictureview").sortable({opacity: 0.8, revert: false, placeholder: "placeHolder", scrollSensitivity: 40, scrollSpeed: 50, cancel: '.notsortable',
        stop: function () {
            picNum();
        }
    });
    //刷新容器数量标识
    $("dl.pictureview dd.notsortable:gt(" + defaultSetting.maxNumber + ")").remove();
    //上传按钮的显示逻辑
    if ($("dl.pictureview dd.haspicture").length == $("dl.pictureview dd").length) {
        $(".uploadbtn").addClass("disabled");
        $(".uploadbtn").click(function () {
            return false; //取消上传事件；
        });
    }
    //按钮显示逻辑
    $("a.insertbtn").text(defaultSetting.insertbtnValue);
    if (defaultSetting.cancelbtnShow = false) {
        $("a.cancelbtn").remove();
    }
    //验证通过前“插入图片”按钮不可用
    //$(".insertpicture a.insertbtn").addClass("disabled"); return flase;
    $(".insertpicture a.insertbtn").click(function () {
        messageInfo("这里是错误提示！！！");
    });
}
