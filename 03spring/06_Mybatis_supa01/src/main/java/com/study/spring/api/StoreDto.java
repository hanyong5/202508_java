package com.study.spring.api;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class StoreDto {

	Long id;
	String name;
	String address;
//	Timestamp created_at;
	List<MenuDto> menus;
	
	
}
