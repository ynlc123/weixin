(function () {   
    var URL;
    var tmp = window.location.pathname;
        URL = "/plugin/ueditor1.2.3.0/";
    window.UEDITOR_CONFIG = {
        UEDITOR_HOME_URL : URL
        ,lang:"zh-cn"
        ,langPath:URL +"lang/"
        ,imageUrl:"/center/upload/image/uploadEditorPic.htm"
        ,imagePath:""
        ,imageFieldName:"uploadFile"
        ,scrawlUrl:URL+"jsp/scrawlUp.jsp"
        ,scrawlPath:URL+"jsp/"
        ,catchRemoteImageEnable:false               //是否开启远程图片抓取,默认开启
        ,catcherUrl:URL +"jsp/getRemoteImage.jsp"
        ,catcherPath:URL + ""
        ,catchFieldName:"upfile"
        //,localDomain:[]                            //本地顶级域名，当开启远程图片抓取时，除此之外的所有其它域名下的图片都将被抓取到本地
        ,imageManagerUrl:"/center/upload/image/manageEditorPic.htm"
        ,imageManagerPath:""           //图片修正地址，同imagePath
        ,getMovieUrl:URL+"jsp/getMovie.jsp"
        ,toolbars:[["Undo","Redo","Preview","|","FontFamily","FontSize","Bold","Italic","Underline","ForeColor","StrikeThrough","Superscript","Subscript","Spechars","|","JustifyLeft","JustifyCenter","JustifyRight","JustifyJustify","InsertUnorderedList","InsertOrderedList","|","InsertImage","ImageNone","ImageLeft","ImageRight","ImageCenter","InsertVideo","|","InsertTable","DeleteTable","|","GMap","Map","|","SearchReplace","SelectAll"]]
        ,labelMap:{'undo':'','redo':'','preview':'','|':'','fontsize':'','bold':'','italic':'','underline':'','forecolor':'','strikethrough':'','superscript':'','subscript':'','pasteplain':'','spechars':'','|':'','justifyleft':'','justifycenter':'','justifyright':'','justifyjustify':'','insertunorderedlist':'','insertorderedlist':'','|':'','insertimage':'','imagenone':'','imageleft':'','imageright':'','imagecenter':'','snapscreen':'','insertvideo':'','|':'','inserttable':'','deletetable':'','|':'','searchreplace':'','selectall':''}
        ,isShow : true
        ,initialContent:""
        ,autoClearinitialContent: false
        ,iframeCssUrl: URL + "/themes/default/iframe.css"
        ,textarea:"editorValue"
        ,focus:false
        ,minFrameHeight:"420"
        ,autoClearEmptyNode : true
        ,fullscreen : false
        ,readonly : false
        ,zIndex : 9
        ,imagePopup:true
        ,initialStyle:'body{font-size:14px}'  
        ,pasteplain:false
        ,insertorderedlist : {"decimal":"1,2,3...","lower-alpha":"a,b,c...","lower-roman":"i,ii,iii...","upper-alpha":"A,B,C","upper-roman":"I,II,III..."}
        ,insertunorderedlist : {"circle":"","disc":"","square":""}
        ,'fontfamily':[{"label":"","name":"songti","val":"宋体,SimSun"},{"label":"","name":"kaiti","val":"楷体,楷体_GB2312, SimKai"},{"label":"","name":"heiti","val":"黑体, SimHei"},{"label":"","name":"lishu","val":"隶书, SimLi"},{"label":"","name":"andaleMono","val":"andale mono"},{"label":"","name":"arial","val":"arial, helvetica,sans-serif"},{"label":"","name":"arialBlack","val":"arial black,avant garde"},{"label":"","name":"comicSansMs","val":"comic sans ms"},{"label":"","name":"impact","val":"impact,chicago"},{"label":"","name":"timesNewRoman","val":"times new roman"}]
        ,'fontsize':[12,14,16,18,20,24,36]
        ,'customstyle':[
            {tag:'h1', name:'', label:'', style:'font-size:16px;line-height:32px;font-weight:700;'},
            {tag:'h2', name:'', label:'', style:'font-size:16px;line-height:32px;font-weight:700;'},
            {tag:'h3', name:'', label:'', style:'font-size:16px;line-height:32px;font-weight:700;'},
            {tag:'h4', name:'', label:'', style:'font-size:16px;line-height:32px;font-weight:700;'},
            {tag:'img', name:'', label:'', style:'max-width:90%;overflow:hidden;'},
            {tag:'p', name:'', label:'', style:'padding:5px 0; text-indent: 2em;'},
        ]
        ,contextMenu:[{"label":"","cmdName":"delete"},{"label":"","cmdName":"selectall"},{"label":"","cmdName":"highlightcode","icon":"deletehighlightcode"},{"label":"","cmdName":"cleardoc","exec":function(){if(confirm("确定清空文档吗？")){this.execCommand("cleardoc");}}},"-",{"label":"","cmdName":"unlink"},"-",{"group":"","icon":"justifyjustify","subMenu":[{"label":"","cmdName":"justify","value":"left"},{"label":"","cmdName":"justify","value":"right"},{"label":"","cmdName":"justify","value":"center"},{"label":"","cmdName":"justify","value":"justify"}]},"-",{"label":"","cmdName":"edittable","exec":function(){this.ui._dialogs["inserttableDialog"].open();}},{"label":"","cmdName":"edittd","exec":function(){if(UE.ui["edittd"]){new UE.ui["edittd"](this);}this.ui._dialogs["edittdDialog"].open();}},{"group":"","icon":"table","subMenu":[{"label":"","cmdName":"deletetable"},{"label":"","cmdName":"insertparagraphbeforetable"},"-",{"label":"","cmdName":"deleterow"},{"label":"","cmdName":"deletecol"},"-",{"label":"","cmdName":"insertrow"},{"label":"","cmdName":"insertcol"},"-",{"label":"","cmdName":"mergeright"},{"label":"","cmdName":"mergedown"},"-",{"label":"","cmdName":"splittorows"},{"label":"","cmdName":"splittocols"},{"label":"","cmdName":"mergecells"},{"label":"","cmdName":"splittocells"}]},{"label":"","cmdName":"copy","exec":function(){alert("请使用ctrl+c进行复制");},"query":function(){return 0;}},{"label":"","cmdName":"paste","exec":function(){alert("请使用ctrl+v进行粘贴");},"query":function(){return 0;}}]
        ,wordCount:true 
        ,maximumWords:1000
        ,tabSize:"4"
        ,tabNode:"&nbsp;"
        ,elementPathEnabled : false
        ,maxUndoCount:"50"
        ,maxInputCount:"50"
        ,autoHeightEnabled:true
        ,autoFloatEnabled:false
        ,indentValue:'2em'
        , serialize : {blackList:{a:1,applet:1,script:1,input:1, meta:1, base:1, button:1, select:1, textarea:1,'map':1, 'area':1}}
    	};
})();
