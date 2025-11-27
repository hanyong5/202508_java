package com.study.spring.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ImageDto {
	private Long id;
	private Integer imageOrder;
	private String fileName;
}
