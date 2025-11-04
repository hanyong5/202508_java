package com.study.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreService {

	@Autowired
	IStoreDao dao;
	
	@Transactional
	public Long createStore(StoreDto store) {
		
		dao.insertStore(store);
		log.info("Store inserted with id: {}", store.getId());
		
		if(store.getMenus() != null) {
			for (MenuDto menu : store.getMenus()) {
                menu.setStore_id(store.getId());  // 가게 id 참조 설정
                log.info("Inserting menu with store_id: {}", menu.getStore_id());
                dao.insertMenu(menu);
            }
		}
		
		return store.getId();
	}
}
