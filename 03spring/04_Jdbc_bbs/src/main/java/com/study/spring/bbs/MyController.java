package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	IBbsDAO dao;

//	@RequestMapping("/")
//	public String root() {
//		return "redirect:index";
//	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists",dao.listDAO());
		model.addAttribute("count",dao.countDAO());
		return "list";
	}
	
	// localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		
		String num =  request.getParameter("id");
		model.addAttribute("dataView",dao.viewDAO(num));
		return "view";
	}
	
	
}
