package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@Autowired
	IBbsDAO dao;

	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "안녕하세요!!!";
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists",dao.listDAO());
		return "index";
	}
}
