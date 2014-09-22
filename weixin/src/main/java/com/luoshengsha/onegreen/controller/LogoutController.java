package com.luoshengsha.onegreen.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 退出登录控制器
 * @author luoshengsha
 * @date 2014年9月10日 下午3:16:01
 */
@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(HttpSession session, HttpServletResponse response) {
		try {
			session.removeAttribute("loginCustomer");
			//转到首页
			response.sendRedirect("/login.htm");
			return null;
		} catch (IOException e) {
			return "500";
		}
	}
}
