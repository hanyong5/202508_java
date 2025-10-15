package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "안녕하세요";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "index";
	}
	@RequestMapping("/test2")
	public String test2() {
		return "test";
	}
}
