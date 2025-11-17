package com.study.spring.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	@Query("select c from Comment c join fetch c.member where c.board.id = :boardId")
	List<Comment> findByBoardId(@Param("boardId") Long boardId);
	
}

