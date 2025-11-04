package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class BbsController {
	
	@Autowired
	IBbsDao dao;

	@GetMapping("/bbs/test")
	public String bbsRoot() {
		return "bbs";
	}
	
	
	@GetMapping("/bbs")
	public List<BbsDto> list(){
		return dao.findAll();
	}
	
	@GetMapping("/bbs/list")
	public BbsDto viewData(
			@RequestParam("id") Long id
			) {
		log.info("view" + id);
		
		
		return dao.findById(id);
	}
	
	@PostMapping("/bbs")
	public void create(
			@RequestBody BbsDto request
			) {
		log.info("title : " + request.title + ", name : " + request.name + ", content : " + request.content);
		dao.create(request);
	}
	
	@PutMapping("/bbs/modify")
	public ResponseEntity<String> modify(
			@RequestParam("id") Long id,
			@RequestBody BbsDto request
			) {
		request.setId(id);
		int updated = dao.update(request);
		if(updated > 0) {
			return ResponseEntity.ok("update success");
		} else {
			return ResponseEntity.badRequest().body("update failed");
		}
	}
	
	
}
