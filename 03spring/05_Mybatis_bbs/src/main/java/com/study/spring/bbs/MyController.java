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
	BbsService service;
	
	
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "test";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists",service.getList());
		model.addAttribute("count",service.count());
		return "list"; // jsp / model value 전송
	}
	
//	@RequestMapping("/view")  // view?id=1
//	public String view(
//			HttpServletRequest req, 
//			Model model
//			) {
//		String sId = req.getParameter("id");
//		model.addAttribute("dataView",dao.viewDao(sId));
//		
//		
//		return "view";
//	}
//	
//	@RequestMapping("/writeForm")
//	public String writeForm() {
//		return "writeForm";
//	}
//	
//	@RequestMapping("/write")
//	public String write(HttpServletRequest request,Model model ) {
//		dao.writeDao(
//				request.getParameter("writer"), 
//				request.getParameter("title"), 
//				request.getParameter("content") 
//				);
//		return "redirect:list";
//	}
//	
//	@RequestMapping("/delete")
//	public String delete(HttpServletRequest request, Model model) {
//		dao.deleteDao(request.getParameter("id"));
//		return "redirect:list";
//	}
}
