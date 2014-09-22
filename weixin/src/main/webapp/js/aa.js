
$(function () {
	// 图片上传函数
    function customAddPicDialog() {
        var picAmount = $(".custom_pic_item").size(), pThis = $(this);
        var customImages = new Array();
        for (var i = 0, len = $(".custom_existPic").size(); i < len; i++) {
            var id = $(".custom_existPic").eq(i).attr("data_id");
            var url = $(".custom_existPic").eq(i).find("img").attr("src");
            var obj = {};
            obj.id = id;
            obj.url = url;
            customImages.push(obj);
        }
        $.ajax({url: "/pictureinto/base/pictureinsert-1.0.js",
            beforeSend: function (XHR) {
                pThis.unbind('click');
                fn_msg({type: "loading", msg: "正在加载数据", time: "load"});
                
            },
            complete: function() {
            	fn_msg({type: "success", msg: "数据加载完成", time: 5000});
            },
            success: jsSuccess, error: function (data, textStatus) {
                fn_msg({type: "error", msg: "系统繁忙，操作失败", time: 5000});
            }, dataType: "script"});
        function jsSuccess(data, textStatus) {
        	
            $.ajax({url: "/center/image/uploadUI.htm",
                data: {dataType: "company"},
                beforeSend: function (XHR) {
                    pThis.unbind('click');
                    fn_msg({type: "loading", msg: "正在加载数据", time: "load"});
                    
                },
                complete: function() {
                	fn_msg({type: "success", msg: "数据加载完成", time: 5000});
                },
                success: picSuccess,
                error: function (data, textStatus) {
                    pThis.bind('click', customAddPicDialog);
                    fn_msg({type: "error", msg: "系统繁忙，操作失败", time: 5000});
                },
                dataType: "html", type: "post"});
            function picSuccess(data) {
                if (!isUserLogin(data)) {
                    return false;
                }
                art.dialog({width: 650, height: 380, padding: 0, title: '插入图片', id: "uploadPhotoDialog", content: data, lock: true, fixed: false, button: [
                    {
                        value: '插入图片',
                        callback: function () {
                            var comLen = $('dl.pictureview dd.complete').size();
                            if (comLen == 0) {
                                $('ul.custom_pic_list li.custom_pic_item').removeAttr('data_id').removeClass('custom_existPic').addClass('product_nopic').find('img,span').remove();
                            } else {
                                $('ul.custom_pic_list li.custom_pic_item').removeAttr('data_id').removeClass('custom_existPic').addClass('product_nopic').find('img,span').remove();
                                for (var i = 0, len = $('dl.pictureview dd.complete').size(); i < len; i++) {
                                    var idStr = $('dl.pictureview dd.complete').eq(i).attr('seq');
                                    var urlStr = $('dl.pictureview dd.complete').eq(i).find('img').attr('src');
                                    $('ul.custom_pic_list li.custom_pic_item').eq(i).children('span').remove()
                                    $('ul.custom_pic_list li.custom_pic_item').eq(i).attr('data_id', idStr).removeClass('custom_existPic').addClass('custom_existPic').removeClass('product_nopic').append('<span class="close_product custom_pic_del"></span>').find('a').html('<img src="' + urlStr + '">');
                                }
                            }
                        },
                        focus: true
                    },
                    {
                        value: '取消'
                    }
                ]});
                var insertPicSetting = ({
                    selectStyle: 2, //默认选择方式，number型，1：从相册中选择；2：本地上传；3：选择网络图片
                    maxNumber: picAmount, //允许上传的最大数量，number型，取值范围：0-10
                    defaultAlbum: 2, //默认选中的相册，number型  0:用户选择； 1：装修相册；2:公司相册
                    isWatermark: true, //是否添加水印，boolean型，可选值：true|false
                    insertbtnValue: "插入图片", //"插入图片"按钮的值
                    cancelbtnShow: true, //是否显示取消按钮
                    fileObjName: "dfa",
                    pictureType: "jpg,jpeg,png,gif", //允许上传的图片类型，string型
                    uploadURL: "/upload/album/", //图片存放路径，string型
                    customImages: customImages            //已上传图片
                });
                insertPicture(insertPicSetting);
                pThis.bind('click', customAddPicDialog);
            }
        }

        return false;
    }

    $(".custom_add_pic").bind('click', customAddPicDialog);
});

