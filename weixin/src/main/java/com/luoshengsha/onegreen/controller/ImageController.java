package com.luoshengsha.onegreen.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 图片控制器
 * @author luoshengsha
 * @date 2014年9月11日 上午9:44:28
 */
@Controller
public class ImageController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(ImageController.class);
    
    @Resource
    private ImageService imageService;
    @Resource
    private PlatformService platformService;

    /**
     * 管理图片
     * @return
     */
    @RequestMapping(value="/center/image/list.htm")
    public ModelAndView manage(@RequestParam(value="pageNo",defaultValue="1") int pageNo) {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
    		
			//页码，每页显示10张图片
			PageView<Image> pageView = new PageView<Image>(pageNo, 10);
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			
			QueryResult<Image> qr = imageService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			return new ModelAndView("/center/image-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示图片列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 上传图片
     */
    @RequestMapping(value="/center/image/upload.htm")
    public void upload() {
    	
    }
    
    /**
     * 删除图片
     */
    @RequestMapping(value="/image/delete.htm")
    @ResponseBody
    public void delete(@RequestParam("uuid") String uuid, HttpServletResponse response) {
    	imageService.delete(uuid);
    	WebUtil.print2JsonMsg(response, true, "删除图片成功！");
    }
    
    @RequestMapping(value="/center/image/uploadUI.htm")
    public String uploadUI() {
    	return "center/upload/image-select";
    }
}
