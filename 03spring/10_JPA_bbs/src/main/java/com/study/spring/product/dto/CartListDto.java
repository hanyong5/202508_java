package com.study.spring.product.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CartListDto {
	private Long id;
	private Long cartId;
	private String memberName;
	private String memberEmail;
	private String productName;
	private Integer productPrice;
	private Integer quantity;
	private Integer totalPrice;
	private LocalDateTime createdAt;
}
