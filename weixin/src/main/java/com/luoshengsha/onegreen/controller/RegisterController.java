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

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.service.CustomerService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 注册控制器
 * @author luoshengsha
 * @date 2014年9月10日 下午3:42:03
 */
@Controller
public class RegisterController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(RegisterController.class);
    
    @Resource
    private CustomerService customerService;

	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("/register.htm")
	public String register() {
		return "register";
	}
	
	/**
	 * 提交注册
	 * @param user
	 * @param repassword
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/register_go.htm")
	public String register_go(Customer customer,@RequestParam(value="repassword",defaultValue="") String repassword, @RequestParam(value="code",defaultValue="") String code,HttpServletRequest request) {
		try {
			//校验注册
			boolean flag = validRegister(customer, repassword, code, request);
			
			if(!flag) {
				return "register";
			}
			customer.setCustomerId(IdGenerator.generateId());
			customer.setCreateTime(new Date());
			customerService.save(customer);
			
			//将注册用户信息保存到会话中
			request.getSession().setAttribute("loginCustomer", customerService.find(customer.getId()));
			
			return "register-success";
		} catch (Exception e) {
			logger.error("注册失败！", e);
			return "register-failure";
		}
	}

	/**
	 * 校验注册
	 * @param customer
	 * @param repassword
	 * @param request
	 * @return code
	 * @return
	 */
	private boolean validRegister(Customer customer, 
			String repassword,
			String code,
			HttpServletRequest request) {
		boolean flag = true;
		if(StringUtils.isEmpty(customer.getName())) {
			request.setAttribute("name_msg", "用户名不能为空！");
			flag = false;
		}
		if(StringUtils.isEmpty(customer.getPassword())) {
			request.setAttribute("password_msg", "密码不能为空！");
			flag = false;
		}
		if(StringUtils.isEmpty(repassword)) {
			request.setAttribute("repassword_msg", "确认密码不能为空！");
			flag = false;
		}
		if(!customer.getPassword().equals(repassword)) {
			request.setAttribute("repassword_msg", "两次输入的密码不一致！");
			flag = false;
		}
		if(!StringUtils.isEmpty(code) && !code.equalsIgnoreCase((String)request.getSession().getAttribute("code"))) {
			request.setAttribute("code_msg", "验证码输入有误！");
			flag = false;
		}
		if(StringUtils.isEmpty(customer.getMobile())) {
			request.setAttribute("mobile_msg", "手机号不能为空！");
			flag = false;
		}
		if(StringUtils.isEmpty(customer.getEmail())) {
			request.setAttribute("email_msg", "邮箱不能为空！");
			flag = false;
		}
		if(customerService.getByAccount(customer.getName()) != null) {
			request.setAttribute("name_msg", "此用户名已被使用！");
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 校验用户名
	 */
	@ResponseBody
	@RequestMapping(value="/register/check_name.htm")
	public void checkName(String name, HttpServletResponse response) {
		try {
			Customer customer = customerService.getByAccount(name);
			if(customer != null) {
				WebUtil.print2JsonMsg(response, false, "此用户名已被占用，请更换用户名！");
			} else {
				WebUtil.print2JsonMsg(response, true, "此用户名可以使用！");
			}
		} catch (Exception e) {
			WebUtil.print2JsonMsg(response, false, "服务器异常，请稍后再试！");
			logger.error("校验用户名失败！",e);
		}
	}
}
