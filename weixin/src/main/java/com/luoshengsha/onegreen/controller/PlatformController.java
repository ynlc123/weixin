package com.luoshengsha.onegreen.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String updatePlatform(Platform platform) {
		try {
			Customer customer = WebUtil.getLoginCustomer();
			Platform customerPlatform = platformService.getByCustomer(customer);
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
			return "redirect:/center/platform/success.htm";
		} catch (Exception e) {
			logger.error("编辑公众号信息失败！", e);
			return "redirect:/center/platform/failure.htm";
		}
	}
	
	/**
	 * 编辑公众号信息成功
	 * @return
	 */
	@RequestMapping(value="/center/platform/success.htm")
	public String success() {
		return "center/platform-success";
	}
	
	/**
	 * 编辑公众号信息失败
	 * @return
	 */
	@RequestMapping(value="/center/platform/failure.htm")
	public String failure() {
		return "center/platform-failure";
	}
}
