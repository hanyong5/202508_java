package com.study.spring.product.dto;

import lombok.Data;

@Data
public class CartCreateDto {
	public Long memberId;
	public Long productId;
	public Integer quantity;
}
