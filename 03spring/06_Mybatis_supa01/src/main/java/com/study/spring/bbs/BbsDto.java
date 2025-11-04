package com.study.spring.bbs;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class BbsDto {

	Long id;
	String title;
	String name;
	String content;

}
