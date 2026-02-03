package com.study.spring.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.product.entity.Cart;
import com.study.spring.product.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	public List<Cart> getCartList(){
		return cartRepository.findAllOrderByIdDesc();
	}
	
	public Cart getCart(Long id) {
		return cartRepository.findCart(id).orElseThrow(
				()-> new RuntimeException("장바구니 항목이 없습니다")
				);
	}
	
	public Page<Cart> getCartPageList(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return cartRepository.findAll(pageable);
	}
	
	public List<Cart> getCartListByMember(Long memberId) {
		return cartRepository.findByMemberId(memberId);
	}
}
