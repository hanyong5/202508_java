package com.study.spring.board.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardCreateDto {
	public String title;
	public String content;
	public Long memberId;
	public List<MultipartFile> fileUploads;
}
