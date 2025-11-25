package com.study.spring.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoardListMemberDto {
	private Long id;
	private String title;
	private String content;
	private String name;
	private String email;
	private LocalDateTime createdAt;
}
