package com.study.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyController {

	@Autowired
	IStoreDao dao;
	
	@Autowired
	StoreService service;
	
	@GetMapping("/")
	public String root() {
		return "test api";
	}
	
	
	@GetMapping("/api/list")
	public List<StoreDto> list() {
		log.info("list");
		return dao.findeAllWidthMenus();
	}
	
	@GetMapping("/api/list1/{id}")
	public StoreDto getView1(
			@PathVariable("id") Long id) {
		return dao.findById(id);
	}
	
	
	@GetMapping("/api/list/{id}")
	public ResponseEntity<StoreDto> getView(
			@PathVariable("id") Long id
			) {
		log.info("정보 : " + id);		
		
		StoreDto store = dao.findById(id);

        if (store == null) {
            return ResponseEntity.notFound().build(); // 404
        }
		
		return ResponseEntity.ok(store);
	}
	
	
	
	
//	{
//		  "name": "ttomi1",
//		  "address": "신길동",
//		  "menus": [
//		    { "name": "맛나", "price": 500 }
//		  ]
//		}
	
	@PostMapping("/api/stores")
	public ResponseEntity<String> create(
			@RequestBody StoreDto store
			){
		
		log.info("store : "+ store.getName()+","+store.getAddress()+","+store.getMenus());
		Long id = service.createStore(store);
		
		
		return ResponseEntity.ok("store insert success / " + id);
		
	}
	
	
}
