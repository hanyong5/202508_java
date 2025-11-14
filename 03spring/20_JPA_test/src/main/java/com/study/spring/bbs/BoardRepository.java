package com.study.spring.bbs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
	@EntityGraph(attributePaths = {"member"})
	Page<Board> findAll(Pageable pageable);
	
}
