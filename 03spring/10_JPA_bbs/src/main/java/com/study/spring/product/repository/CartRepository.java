package com.study.spring.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.product.dto.CartListDto;
import com.study.spring.product.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("select c from Cart c order by c.id desc")
	List<Cart> findAllOrderByIdDesc();
	
	@Query("select c from Cart c where c.id = :id")
	Optional<Cart> findCart(@Param("id") Long id);
	
	@Query("select c from Cart c where c.member.id = :memberId order by c.id desc")
	List<Cart> findByMemberId(@Param("memberId") Long memberId);
	
	@Query("""
			select new com.study.spring.product.dto.CartListDto(
				c.id,
				c.id,
				m.name,
				m.email,
				p.name,
				p.price,
				c.quantity,
				p.price * c.quantity,
				c.createdAt
			)
			from Cart c
			join c.member m
			join c.product p
			order by c.id desc
			""")
	List<CartListDto> findAllCartListDto();
	
	@Query("""
			select distinct c
			from Cart c
			join fetch c.member m
			join fetch c.product p
			order by c.id desc
			""")
	List<Cart> findWithMemberAndProduct();
	
	@Query("""
			select distinct c
			from Cart c
			join fetch c.member m
			join fetch c.product p
			order by c.id desc
			""")
	Page<Cart> findWithMemberAndProductPage(Pageable pageable);
	
	@Query("""
			select c 
			from Cart c 
			join fetch c.member m
			join fetch c.product p
			where c.id = :id
			""")
	Cart findWithMemberAndProductById(@Param("id") Long id);
	
	@Query("""
			select c 
			from Cart c 
			join fetch c.member m
			join fetch c.product p
			where c.member.id = :memberId
			order by c.id desc
			""")
	List<Cart> findWithMemberAndProductByMemberId(@Param("memberId") Long memberId);
}
