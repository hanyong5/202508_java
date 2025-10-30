package com.study.spring.api;

import java.sql.Timestamp;


import lombok.Data;

@Data
public class PostDto {
	int id;
	String title;
	String content;
	String name;
	Timestamp created_at;
}
