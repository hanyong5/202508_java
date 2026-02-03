package com.study.spring.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.product.dto.CartCreateDto;
import com.study.spring.product.entity.Cart;
import com.study.spring.product.repository.CartRepository;
import com.study.spring.product.repository.ProductRepository;
import com.study.spring.member.entity.Member;
import com.study.spring.product.entity.Product;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CartCreateService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;

	public Long cartCreateData(CartCreateDto req) {
		log.info("member id	: " + req.getMemberId());
		log.info("product id	: " + req.getProductId());
		log.info("quantity	: " + req.getQuantity());
		
		// Product 조회
		Product product = productRepository.findProduct(req.getProductId())
				.orElseThrow(() -> new RuntimeException("상품이 없습니다"));
		
		// 재고 확인
		if (product.getStock() < req.getQuantity()) {
			throw new RuntimeException("재고가 부족합니다. 현재 재고: " + product.getStock());
		}
		
		// Cart Entity 생성
		Cart cart = new Cart();
		cart.setQuantity(req.getQuantity());
		
		// Member 설정
		Member member = new Member();
		member.setId(req.getMemberId());
		cart.setMember(member);
		
		// Product 설정
		cart.setProduct(product);
		
		// 저장
		Cart savedCart = cartRepository.save(cart);
		log.info("cart created successfully with id: " + savedCart.getId());
		return savedCart.getId();
	}
}
