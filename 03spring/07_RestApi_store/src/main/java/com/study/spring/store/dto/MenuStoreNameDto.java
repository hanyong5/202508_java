package com.study.spring.store.dto;

import lombok.Data;

@Data
public class MenuStoreNameDto {
	public Long id;
	public String name;
	public int price;
	public Long Store_id;
	public StoreDto store; // object
}

