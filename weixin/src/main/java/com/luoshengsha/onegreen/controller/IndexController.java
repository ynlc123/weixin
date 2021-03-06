package com.luoshengsha.onegreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * @author luoshengsha
 * @date 2014年9月21日 下午8:02:41
 */
@Controller
public class IndexController {
	
	@ModelAttribute(value="nav")
	public String getNav() {
		return "index";
	}
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "index";
	}
}
