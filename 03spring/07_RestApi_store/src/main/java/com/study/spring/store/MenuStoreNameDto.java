package com.study.spring.store;

import lombok.Data;

@Data
public class MenuStoreNameDto {
	Long id;
	String name;
	int price;
	Long Store_id;
	StoreDto store; // object
}

