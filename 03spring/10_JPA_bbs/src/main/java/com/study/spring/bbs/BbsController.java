package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	
	
	
	// 전체데이터
//	@GetMapping("/api/bbs")
//	public List<Bbs> bbsList(){
////		return bbsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
//		return bbsRepository.findAllByOrderByIdDesc();
//	}
	
	
	// 페이지네이션
	//http://localhost:8080/api/bbs?size=5&page=0&title=test
	@GetMapping("/api/bbs")
	public Page<Bbs> bbsList(
			@RequestParam(name="title",defaultValue="") String title,
//			@RequestParam(name="name",defaultValue="") String name,
			@RequestParam(name="size", defaultValue="5") int size,
			@RequestParam(name="page",defaultValue="0") int page
			) {
		
		Pageable pageable = PageRequest.of(page, size,Sort.by(Sort.Direction.DESC,"id"));
//		return bbsRepository.findAll(pageable);
		return bbsRepository.findByTitleContaining(title,pageable);
//		return bbsRepository.findByTitleContainingOrNameContaining(title,name,pageable);
		
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
