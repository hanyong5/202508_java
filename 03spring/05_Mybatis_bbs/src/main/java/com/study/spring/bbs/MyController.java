package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	IBbsDao dao;
	
	
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "test";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists",dao.listDao());
		model.addAttribute("count",dao.countDao());
		return "list"; // jsp / model value 전송
	}
	
	@RequestMapping("/view")  // view?id=1
	public String view(
			HttpServletRequest req, 
			Model model
			) {
		String sId = req.getParameter("id");
		model.addAttribute("dataView",dao.viewDao(sId));
		
		
		return "view";
	}
}
