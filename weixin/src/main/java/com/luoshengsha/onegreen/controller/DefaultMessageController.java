package com.luoshengsha.onegreen.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.DefaultMessage;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.DefaultMessageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 默认自动回复信息
 * @author luoshengsha
 * @date 2014年9月11日 上午11:15:19
 */
@Controller
public class DefaultMessageController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(DefaultMessageController.class);
    
    @Resource
    private DefaultMessageService messageService;
    @Resource
    private PlatformService platformService;
    
    /**
     * 显示默认自动回复信息
     * @return
     */
    @RequestMapping(value="/center/defReplyMsg.htm")
    public ModelAndView defaultReplyMessage() {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
			DefaultMessage message = messageService.getByPlatform(platform);
			
			return new ModelAndView("/center/defReplyMsg", "message", message);
		} catch (Exception e) {
			logger.error("显示默认自动回复信息失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 更新默认自动回复信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/center/defReplyMsg/update.htm")
    public void update(@RequestParam(value="content") String content, HttpServletResponse response) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			DefaultMessage message = messageService.getByPlatform(platform);
			if(message == null) {
				message = new DefaultMessage();
			}
			message.setContent(content);
			message.setEditTime(new Date());
			message.setPlatform(platform);
			messageService.edit(message);
			WebUtil.print2JsonMsg(response, true, "修改默认自动回复信息成功！");
		} catch (Exception e) {
			logger.error("", e);
			WebUtil.print2JsonMsg(response, false, "修改默认自动回复信息失败！");
		}
    }
}
