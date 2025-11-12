package com.study.spring.file;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestDto {
	public String title;
	public String content;
	public String name;
	public MultipartFile fileUpload;
}
