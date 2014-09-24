package com.luoshengsha.onegreen.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.service.CustomerService;
import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 客户控制器
 * @author luoshengsha
 * @date 2014年9月10日 下午5:30:43
 */
@Controller
@RequestMapping(value="/center/customer")
public class CustomerController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(CustomerController.class);
	@Resource
	private CustomerService customerService;
	
	/**
	 * 编辑
	 */
	@RequestMapping(value="/edit.htm")
	public ModelAndView edit(HttpServletRequest request) {
		
		Customer customer = customerService.find(WebUtil.getLoginCustomer().getId());

		return new ModelAndView("center/customer-edit","customer", customer);
	}
	
	/**
	 * 更新客户资料
	 * @param customer
	 */
	@ResponseBody
	@RequestMapping(value="/update.htm")
	public void update(Customer customer, HttpServletResponse response) {
		try {
			Customer loginCustomer = WebUtil.getLoginCustomer();
			loginCustomer.setRealName(customer.getRealName());
			loginCustomer.setMobile(customer.getMobile());
			loginCustomer.setPhone(customer.getPhone());
			loginCustomer.setFax(customer.getFax());
			loginCustomer.setEmail(customer.getEmail());
			loginCustomer.setEditTime(new Date());
			
			customerService.update(loginCustomer);
			
			WebUtil.print2JsonMsg(response, false, "更新资料成功！");
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "更新资料失败！");
			logger.error("更新客户资料失败！", e);
		}
	}
	
	/**
	 * 编辑密码界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/edit_password.htm")
	public String editPassword(HttpServletRequest request) {
		return "center/edit-password";
	}
	
	/**
	 * 修改密码
	 * @param oldpassword 旧密码
	 * @param newpassword 新密码
	 * @param re_newpassword 确认新密码
	 * @return
	 */
	@RequestMapping("/update_password.htm")
	@ResponseBody
	public void updatePassword(
			@RequestParam(value = "oldpassword") String oldpassword,
			@RequestParam(value = "newpassword") String newpassword,
			@RequestParam(value = "re_newpassword") String re_newpassword,
			HttpServletResponse response) {
		//验证是否为空
		if(StringUtils.isEmpty(oldpassword)) {
			WebUtil.print2JsonMsg(response, false, "旧密码不能为空！");
			return;
		} else if(StringUtils.isEmpty(newpassword)) {
			WebUtil.print2JsonMsg(response, false, "新密码不能为空！");
			return;
		} else if(StringUtils.isEmpty(re_newpassword)) {
			WebUtil.print2JsonMsg(response, false, "请再次确认新密码！");
			return;
		} else if(!newpassword.equals(re_newpassword)) {
			WebUtil.print2JsonMsg(response, false, "两次输入的密码不一致！");
			return;
		}
		
		try {
			//验证旧密码是否正确
			if(!customerService.checkCustomer(WebUtil.getLoginCustomer().getName(), oldpassword)) {
				WebUtil.print2JsonMsg(response, false, "旧密码输入有误，请重新输入！");
				return;
			}
			//更新密码
			customerService.updatePwd(newpassword, WebUtil.getLoginCustomer());
			WebUtil.print2JsonMsg(response, true, "密码修改成功！");
		} catch (Exception e) {
			logger.error("修改密码失败！", e);
			WebUtil.print2JsonMsg(response, false, "密码修改失败！");
		}
	}
}
