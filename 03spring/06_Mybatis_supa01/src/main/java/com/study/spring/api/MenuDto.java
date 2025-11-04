package com.study.spring.api;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MenuDto {
	Long id;
	Long store_id;
	String name;
	int price;
//	Timestamp created_at;
}
