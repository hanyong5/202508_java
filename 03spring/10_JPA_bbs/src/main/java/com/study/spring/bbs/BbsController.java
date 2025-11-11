package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	BbsRepository bbsRepository;
	
	@GetMapping("/")
	public String root() {
		return "hi";
	}
	
	@GetMapping("/api/bbs")
	public List<Bbs> bbsList(){
//		return bbsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
		return bbsRepository.findAllByOrderByIdDesc();
	}
	
//	@GetMapping("/api/bbs/{id}")
//	public Optional<Bbs> bbsView(
//			@PathVariable("id") Long id
//			){
//		log.info("id : " + id);
//		return bbsRepository.findById(id);
//	}
	
	@GetMapping("/api/bbs/{id}")
	public Optional<Bbs> bbsView(
			@PathVariable("id") Long id
			) {
		return bbsRepository.findById(id);
	}
	
	@PostMapping("/api/bbs")
	public Bbs bbsCreate(
			@RequestBody BbsDto req
			) {
//		Bbs bbs = new Bbs();
//		bbs.setName(req.name);
//		bbs.setTitle(req.title);
//		bbs.setContent(req.content);
		
		Bbs bbs = Bbs.builder()
				.name(req.getName())
				.title(req.getTitle())
				.content(req.getContent())
				.build();
			
		return bbsRepository.save(bbs);
	}
	
	@PutMapping("/api/bbs/{id}")
	public void bbsUpdate(
			@PathVariable("id") Long id,
			@RequestBody BbsDto req
			){
		
		
//		Bbs bbsEntity = bbsRepository.findById(id).orElseThrow(
//				()-> new RuntimeException("자료가 없네요")
//				);
		
		Optional<Bbs> view = bbsRepository.findById(id);
		log.info("정보확인" + view.toString());
		
		if(view.isEmpty()) {
			log.info("자료가 없네요");
		}else {
			Bbs entity = view.get();
			entity.setName(req.getName());
			entity.setTitle(req.getTitle());
			entity.setContent(req.getContent());
			
			bbsRepository.save(entity);
			log.info("수정완료");
		}
		
	}
	
	
	@DeleteMapping("/api/bbs/{id}")
	public ResponseEntity<?> bbsDelete(
			@PathVariable("id") Long id
			){
		boolean bbs = bbsRepository.existsById(id);
		if(!bbs) {
			return ResponseEntity.notFound().build();
		}
		
		bbsRepository.deleteById(id);
		return ResponseEntity.ok("삭제완료");
		
	}
	
	
	
//	public void bbsList(){}
//	public void bbsView(){}
//	public void bbsCreate(){}
//	public void bbsUpdate(){}
//	public void bbsDelete(){}
	
	
	
}
