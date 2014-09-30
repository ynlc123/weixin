package com.luoshengsha.onegreen.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.LinkUs;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.LinkUsService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 联系我们控制器
 * @author luoshengsha
 * @date 2014年9月11日 上午9:22:15
 */
@Controller
public class LinkUsController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(LinkUsController.class);
    
    @Resource
    private LinkUsService linkUsService;
    @Resource
    private PlatformService platformService;
	
    /**
     * 联系我们
     * @return
     */
    @RequestMapping(value="/center/linkus.htm")
    public ModelAndView linkUs() {
    	Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
		if(platform == null) {
			return new ModelAndView("redirect:/center/platform.htm");
		}
    	LinkUs linkUs = linkUsService.getByPlatform(platform);
    	
    	return new ModelAndView("center/linkUs", "linkUs", linkUs);
    }
    
    /**
     * 更新联系我们
     * @param linkUs
     * @return
     */
    @RequestMapping(value="/center/linkus/update.htm")
    @ResponseBody
    public void updateLinkUs(LinkUs linkUs, HttpServletResponse response) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			LinkUs newLinkUs = linkUsService.getByPlatform(platform);
			
			if(newLinkUs == null) {
				newLinkUs = new LinkUs();
				newLinkUs.setUuid(IdGenerator.generateId());
				newLinkUs.setPlatform(platform);
			}
			newLinkUs.setContent(linkUs.getContent());
			newLinkUs.setEditTime(new Date());
			linkUsService.edit(newLinkUs);
			WebUtil.print2JsonMsg(response, true, "编辑成功！");
		} catch (Exception e) {
			logger.error("更新联系我们失败", e);
			WebUtil.print2JsonMsg(response, false, "编辑失败！");
		}
    }
}
