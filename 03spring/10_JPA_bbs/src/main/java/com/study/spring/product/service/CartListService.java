package com.study.spring.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.product.dto.CartDto;
import com.study.spring.product.dto.CartListDto;
import com.study.spring.product.entity.Cart;
import com.study.spring.product.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartListService {
	
	@Autowired
	CartRepository cartRepository;

	public List<CartListDto> findWithMemberAndProduct() {
		return cartRepository.findAllCartListDto();
	}

	public List<CartDto> findWithMemberAndProductList() {
		
		//entity
		List<Cart> carts = cartRepository.findWithMemberAndProduct();
		
		return carts.stream()
				.map(c -> CartDto
						.builder()
						.id(c.getId())
						.quantity(c.getQuantity())
						.createdAt(c.getCreatedAt())
						.memberId(c.getMember().getId())
						.memberName(c.getMember().getName())
						.productId(c.getProduct().getId())
						.productName(c.getProduct().getName())
						.productPrice(c.getProduct().getPrice())
						.build())
				.toList();
	}

	public Page<CartDto> findWithMemberAndProductPage(Pageable pageable) {

		//entity
		Page<Cart> page = cartRepository.findWithMemberAndProductPage(pageable);
		
		//return entity -> dto - json
		return page.map(
				c -> CartDto.builder()
				.id(c.getId())
				.quantity(c.getQuantity())
				.createdAt(c.getCreatedAt())
				.memberId(c.getMember().getId())
				.memberName(c.getMember().getName())
				.productId(c.getProduct().getId())
				.productName(c.getProduct().getName())
				.productPrice(c.getProduct().getPrice())
				.build()
				);
	}

	public CartDto findWithMemberAndProductById(Long id) {
		
		//entity 
		Cart c = cartRepository.findWithMemberAndProductById(id);
		
		//entity -> dto
		return CartDto.builder()
				.id(c.getId())
				.quantity(c.getQuantity())
				.createdAt(c.getCreatedAt())
				.memberId(c.getMember().getId())
				.memberName(c.getMember().getName())
				.productId(c.getProduct().getId())
				.productName(c.getProduct().getName())
				.productPrice(c.getProduct().getPrice())
				.build();
	}
	
	public List<CartDto> findWithMemberAndProductByMemberId(Long memberId) {
		
		//entity 
		List<Cart> carts = cartRepository.findWithMemberAndProductByMemberId(memberId);
		
		//entity -> dto
		return carts.stream()
				.map(c -> CartDto.builder()
						.id(c.getId())
						.quantity(c.getQuantity())
						.createdAt(c.getCreatedAt())
						.memberId(c.getMember().getId())
						.memberName(c.getMember().getName())
						.productId(c.getProduct().getId())
						.productName(c.getProduct().getName())
						.productPrice(c.getProduct().getPrice())
						.build())
				.toList();
	}
}
