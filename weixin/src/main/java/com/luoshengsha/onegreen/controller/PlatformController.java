package com.luoshengsha.onegreen.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 公众平台控制器
 * @author luoshengsha
 * @date 2014年9月10日 下午10:40:25
 */
@Controller
public class PlatformController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(PlatformController.class);
    
    @Resource
    private PlatformService platformService;
    
	/**
	 * 显示公众号信息
	 * @return
	 */
	@RequestMapping(value="/center/platform.htm")
	public ModelAndView platform() {
		//获取公众平台信息
		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		return new ModelAndView("center/platform", "platform", platform);
	}
	
	/**
	 * 更新公众号信息
	 * @return
	 */
	@RequestMapping(value="/center/platform/update.htm",method=RequestMethod.POST)
	@ResponseBody
	public void updatePlatform(Platform platform, HttpServletResponse response) {
		try {
			Customer customer = WebUtil.getLoginCustomer();
			Platform customerPlatform = platformService.getByCustomer(customer);
			
			boolean originalIdExsit = checkOriginalId(platform.getOriginalId(), customerPlatform);
			if(originalIdExsit) {
				WebUtil.print2JsonMsg(response, false, "此公众号原始id已存在！");
				return ;
			}
			
			boolean appIdExsit = checkAppId(platform.getAppId(), customerPlatform);
			if(appIdExsit) {
				WebUtil.print2JsonMsg(response, false, "此公众号appId已存在！");
				return ;
			}
			
			if(customerPlatform == null) {
				customerPlatform = new Platform();
				customerPlatform.setUuid(IdGenerator.generateId());
				customerPlatform.setCreateTime(new Date());
				customerPlatform.setValidTime(new Date(System.currentTimeMillis()+365*24*60*60*1000l));
			}
			customerPlatform.setOriginalId(platform.getOriginalId());
			customerPlatform.setPlatformNo(platform.getPlatformNo());
			customerPlatform.setUserName(platform.getUserName());
			customerPlatform.setPassword(platform.getPassword());
			customerPlatform.setAppId(platform.getAppId());
			customerPlatform.setAppSecret(platform.getAppSecret());
			customerPlatform.setCustomer(customer);
			customerPlatform.setPlatformType(platform.getPlatformType());
			customerPlatform.setAuth(platform.isAuth());
			customerPlatform.setEditTime(new Date());
			
			platformService.edit(customerPlatform);
			
			WebUtil.print2JsonMsg(response, true, "设置公众号信息成功！");
		} catch (Exception e) {
			logger.error("编辑公众号信息失败！", e);
			WebUtil.print2JsonMsg(response, false, "设置公众号信息失败！");
		}
	}
	
	/**
	 * 校验公众号原始id
	 * @param originalId
	 * @param response
	 */
	@RequestMapping(value="/center/platform/checkOriginalId.htm",method=RequestMethod.POST)
	@ResponseBody
	public void checkOriginalId(String originalId, HttpServletResponse response) {
		Platform customerPlatform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		boolean flag = checkOriginalId(originalId, customerPlatform);
		if(flag) {
			WebUtil.print2JsonMsg(response, false, "此公众号原始id已存在！");
		} else {
			WebUtil.print2JsonMsg(response, true, "此公众号原始id可以使用！");
		}
	}
	
	/**
	 * 校验公众号原始id是否已重复
	 * @param originalId
	 * @param customerPlatform
	 * @return
	 */
	private boolean checkOriginalId(String originalId, Platform customerPlatform) {
		Platform newPlatform = platformService.getByOriginalId(originalId);
		if(newPlatform != null && !customerPlatform.equals(newPlatform)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 校验公众号appId
	 * @param originalId
	 * @param response
	 */
	@RequestMapping(value="/center/platform/checkAppId.htm",method=RequestMethod.POST)
	@ResponseBody
	public void checkAppId(String appId, HttpServletResponse response) {
		Platform customerPlatform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		boolean flag = checkAppId(appId, customerPlatform);
		if(flag) {
			WebUtil.print2JsonMsg(response, false, "此公众号appId已存在！");
		} else {
			WebUtil.print2JsonMsg(response, true, "此公众号appId可以使用！");
		}
	}
	
	/**
	 * 校验AppId是否重复
	 * @param appId
	 * @param customerPlatform
	 * @return
	 */
	private boolean checkAppId(String appId, Platform customerPlatform) {
		Platform newPlatform = platformService.getByAppID(appId);
		if(newPlatform != null && !customerPlatform.equals(newPlatform)) {
			return true;
		} else {
			return false;
		}
	}
}
