package com.luoshengsha.onegreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 案例控制器
 * @author luoshengsha
 * @date 2014年10月5日 下午2:05:49
 */
@Controller
@RequestMapping(value="/case.htm")
public class CaseController {
	
	@ModelAttribute(value="nav")
	public String getNav() {
		return "case";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		return "case";
	}
}
