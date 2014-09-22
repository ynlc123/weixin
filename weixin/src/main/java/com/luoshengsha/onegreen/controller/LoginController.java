package com.luoshengsha.onegreen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.iharder.Base64;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.service.CustomerService;

/**
 * 登录控制器
 * @author luoshengsha
 * @date 2014年9月10日 下午3:02:56
 */
@Controller
public class LoginController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(LoginController.class);
    @Resource
    private CustomerService customerService;

	/**
	 * 登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request) {
		request.setAttribute("sendUrl", request.getParameter("sendUrl"));
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login_go.htm")
	public String login_go(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "sendUrl", defaultValue="") String sendUrl,
			String ids) {
		//判断是否为空！
		boolean isEmpty = false;
		if(StringUtils.isEmpty(name)) {
			request.setAttribute("name_msg", "用户名不能为空！");
			isEmpty = true;
		}
		if(StringUtils.isEmpty(password)) {
			request.setAttribute("password_msg", "密码不能为空！");
			isEmpty = true;
		}
		if(isEmpty) {
			request.setAttribute("name", name);
			return "login";
		}
System.out.println("ids: " + ids);		
		try {
			//账户或密码有误，返回登录页面
			if(!customerService.checkCustomer(name, password)) {
				request.setAttribute("msg", "用户名或密码不正确！");
				return "login";
			}
			
			Customer loginCustomer = customerService.getByAccount(name);
System.out.println(loginCustomer.getPlatform());
			request.getSession().setAttribute("loginCustomer", loginCustomer);
	
			if(StringUtils.isEmpty(sendUrl)) {
				//转到首页
				response.sendRedirect("/index.htm");
			} else {//跳转到相应的页面
				response.sendRedirect(new String(Base64.decode(sendUrl)));
			}
			return null;
		} catch (Exception e) {
			logger.error("用户登录失败", e);
			return "500";
		}
	}
}
