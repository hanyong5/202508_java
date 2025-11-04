package com.study.spring.store;

import lombok.Data;

@Data
public class MenuDto {
	Long id;
	String name;
	int price;
	Long Store_id;
}
