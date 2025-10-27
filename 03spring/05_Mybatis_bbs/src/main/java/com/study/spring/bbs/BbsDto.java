package com.study.spring.bbs;

import lombok.Data;

@Data
public class BbsDto {
	public int id;
	public String writer;
	public String title;
	public String content;
}
