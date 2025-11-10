package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsController {
	
	@Autowired
	BbsRepository bbsRepository;
	
	@GetMapping("/")
	public String root() {
		return "hi";
	}
	
	@GetMapping("/bbs")
	public List<Bbs> bbsList(){
//		return bbsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
		return bbsRepository.findAllByOrderByNameDesc();
	}
	
}
