package com.study.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.board.dto.BoardListDto;
import com.study.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	@Query("""
			select b
			from Board b
			order by
			b.id desc
			""")
	List<Board> findAllOrderByIdDesc();
	
	@Query("""
			select new com.study.spring.board.dto.BoardListDto(
			 b.id,
			 b.title,
			 b.name,
			 b.createdAt
			)
			from Board b
			order by b.id desc
			""")
	List<BoardListDto> findAllListDto();
	
	
	
	@Query("select b from Board b where b.id = :id")
	Optional<Board> findBoard(@Param("id") Long id);
	
	
	
	@Query("select b from Board b order by b.id desc")
	Page<Board> findAllWithPage(Pageable pageable);
	
	
	
	
}
