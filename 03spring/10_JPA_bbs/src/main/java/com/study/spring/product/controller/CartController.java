package com.study.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.product.dto.CartCreateDto;
import com.study.spring.product.dto.CartDto;
import com.study.spring.product.dto.CartListDto;
import com.study.spring.product.repository.CartRepository;
import com.study.spring.product.service.CartCreateService;
import com.study.spring.product.service.CartListService;
import com.study.spring.product.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartListService cartListService;
	
	@Autowired
	CartCreateService cartCreateService;
	
	@Autowired
	CartService cartService;
	
	
	//get, pagination
	
	@GetMapping("/api/cart")
	public List<CartListDto> cartList() {
		return cartListService.findWithMemberAndProduct();
	}
	
	@GetMapping("/api/cart/list")
	public List<CartDto> cartListDto() {
		return cartListService.findWithMemberAndProductList();
	}
	
	// ~/api/cartp?page=0&size=10
	@GetMapping("/api/cartp")
	public Page<CartDto> cartListPage(
			@RequestParam(name="page",defaultValue = "0") int page,
			@RequestParam(name="size",defaultValue = "10") int size
			) {
		
		Pageable pageable = PageRequest.of(page, size);
		return cartListService.findWithMemberAndProductPage(pageable);
	}
	
	@GetMapping("/api/cart/{id}")
	public CartDto cartView(
			@PathVariable("id") Long id
			) {
		return cartListService.findWithMemberAndProductById(id);
	}
	
	@GetMapping("/api/cart/member/{memberId}")
	public List<CartDto> cartListByMember(
			@PathVariable("memberId") Long memberId
			) {
		return cartListService.findWithMemberAndProductByMemberId(memberId);
	}
	
	
	//post
	@PostMapping("/api/cart")
	public ResponseEntity<?> cartCreate(
			@ModelAttribute CartCreateDto req
			) {
		Long id = cartCreateService.cartCreateData(req);
		return ResponseEntity.ok("장바구니 추가 완료, id: " + id);
	}
	
	
	
	//update
	//delete
	
	
}
