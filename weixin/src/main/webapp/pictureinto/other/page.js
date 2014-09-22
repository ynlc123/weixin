var default_page_set={
    page_name:"pager.php",
    items_per_page:20,
    def_page:1,
    current_page:1,
    containClass:"picturelist",
    center_page:5,
    page_class:"page",
    d_prev_page:{cls:"prev_cur",name:"上一页"},
    e_prev_page:{cls:"pageprev",name:"上一页"},
    d_next_page:{cls:"next_cur",name:"下一页"},
    e_next_page:{cls:"pagenext",name:"下一页"},
    normal_page:{cls:"pagenum"},
    ell_page:{cls:"e_cur"},
    selected_page:{cls:"cur"},
    err_msg:{msg:"没有你要查找的数据"}
};
function fan_pager(page_set){
    function numPages(maxentries) {
        return Math.ceil(maxentries/page_set.items_per_page);
    }
    function default_success(data,textStatus){
        var gd=eval(data);
        var dc=parseInt(gd.dataCount);
        var re_c=gd.result;
        var r_len=gd.result.length;
        if(dc>0 && r_len>0){
            var page_i=numPages(dc);
            page_set.datadisplay(page_set,re_c);
            var str_p='';
            if(parseInt(page_set.current_page)==1){
                var str_p='<li class="'+page_set.d_prev_page.cls+'">'+page_set.d_prev_page.name+'</li>';
            }
            else{
                var str_p='<li class="'+page_set.e_prev_page.cls+'">'+page_set.e_prev_page.name+'</li>';
            }
            var startpage = page_set.current_page
                - parseInt(page_set.center_page % 2 == 0 ? page_set.center_page / 2 - 1
                : page_set.center_page / 2);
            var endpage = page_set.current_page + parseInt(page_set.center_page / 2);
            if (startpage < 1) {
                startpage = 1;
                if (page_i >= page_set.center_page)
                    endpage = page_set.center_page;
                else
                    endpage = page_i;
            }
            if (endpage > page_i) {
                endpage = page_i;
                if ((endpage - page_set.center_page) > 0)
                    startpage = endpage - page_set.center_page + 1;
                else
                    startpage = 1;
            }
            if(endpage>page_set.center_page){
                if(parseInt(endpage-1)==page_set.center_page){
                    str_p+='<li class="'+page_set.normal_page.cls+'" index="'+page_set.def_page+'">'+page_set.def_page+'</li>'
                }
                else{
                    str_p+='<li class="'+page_set.normal_page.cls+'" index="'+page_set.def_page+'">'+page_set.def_page+'</li><li class="'+page_set.ell_page.cls+'"">...</li>'
                }
            }
            for(var j=startpage;j<=endpage;j++){
                if(j==parseInt(page_set.current_page)){
                    str_p+='<li class="'+page_set.selected_page.cls+'" index="'+j+'">'+j+'</li>'
                }
                else{
                    str_p+='<li class="'+page_set.normal_page.cls+'" index="'+j+'">'+j+'</li>'
                }
            }
            if(endpage<page_i){
                if(parseInt(endpage+1)==page_i){
                    str_p+='<li class="'+page_set.normal_page.cls+'" index="'+page_i+'">'+page_i+'</li>'
                }
                else{
                    str_p+='<li class="'+page_set.ell_page.cls+'"">...</li><li class="'+page_set.normal_page.cls+'" index="'+page_i+'">'+page_i+'</li>'
                }
            }
            if(parseInt(page_i)==parseInt(page_set.current_page)){
                str_p+='<li class="'+page_set.d_next_page.cls+'">'+page_set.d_next_page.name+'</li>';
            }
            else{
                str_p+='<li class="'+page_set.e_next_page.cls+'">'+page_set.d_next_page.name+'</li>';
            }
            $('.'+page_set.page_class).empty();
            $('.'+page_set.page_class).append(str_p);
            $('.pageprev').click(function(){
                var tpage=parseInt($('.cur').attr("index"));
                if(tpage>1){
                    var prev_set=page_set;
                    prev_set.current_page=page_set.current_page=parseInt(tpage-1);
                    fan_pager(prev_set);
                }
            });
            $('.pagenext').click(function(){
                var tpage=parseInt($('.cur').attr("index"));
                if(tpage<page_i){
                    var next_set=page_set;
                    next_set.current_page=page_set.current_page=parseInt(tpage+1);
                    fan_pager(next_set);
                }
            });
            $('.page .pagenum').click(function(){
                var i_index=parseInt($(this).attr("index"));
                var c_set=page_set;
                c_set.current_page=i_index;
                fan_pager(c_set);
            });
        }
        else{
            $('.'+page_set.page_class).empty();
            $('.'+page_set.containClass).empty();
            messageInfo(page_set.err_msg.msg);
        }
    }
    $.ajax({url:page_set.page_name,data:{items_per_page:page_set.items_per_page,current_page:page_set.current_page,param_list:page_set.param_list,pageNo:page_set.current_page,albumId:page_set.param_list,showAmount:page_set.items_per_page},success:default_success,type:"post",error:page_set.getError,dataType:"json"});
}