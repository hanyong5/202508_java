package com.study.spring.bbs;

import lombok.Data;

@Data
public class BoardDto {
	
	private String title;
	private String content;
	private String name;
	private String imageFileName;
	private Long memberId;
	
}

