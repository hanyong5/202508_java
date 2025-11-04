package com.study.spring.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StoreController {
	
	@Autowired
	IStoreDao dao;

	@GetMapping("/")
	public String root() {
		return "store";
	}
	
	@GetMapping("/api/store")
	public List<StoreDto> listStore(){
		return dao.findAll();
	}
	
	///api/store/view?id=1
	@GetMapping("/api/store/view")
	public StoreDto viewStore(
			@RequestParam("id") Long id
			) {
		log.info("view id : " +id);
		return dao.storeView(id);
	}
	
//	{
//	    "name":"우리집",
//	    "addr":"마포"
//	}
	@PostMapping("/api/store")
	public void createStore(
			@RequestBody StoreDto request
			) {
		
		log.info("post : name - "+request.name + ", addr - " + request.addr);
		dao.createStore(request);
		
	}
	
	
	
	
	@GetMapping("/api/menu")
	public List<MenuDto> listMenu(){
		return dao.findMenuAll();
	}
	
	//~/api/menuStroe?storeId=
	@GetMapping("/api/menuStore")
	public List<MenuDto> menuStoreView(
			@RequestParam("storeId") Long store_id
			) {
		return dao.findMenuByStoreId(store_id);
	}
	
	@GetMapping("/api/storeMenu")
	public List<StoreMenuDto> storeMenuList(){
		return dao.storeAndMenuAll();
	}
	
	@GetMapping("/api/menuStoreName")
	public List<MenuStoreNameDto> menuStoreName(){
		return dao.menuStoreName();
	}
	
	
}
