package com.luoshengsha.onegreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload.htm")
	public String upload() {
		return "upload";
	}
}
