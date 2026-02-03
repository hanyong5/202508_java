package com.study.spring.product.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CartDto {
	private Long id;
	private Integer quantity;
	private LocalDateTime createdAt;
	private Long memberId;
	private String memberName;
	private Long productId;
	private String productName;
	private Integer productPrice;
}
