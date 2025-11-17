package com.study.spring.comment;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import com.study.spring.bbs.Board;
import com.study.spring.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="comment_table")
public class Comment {
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String comment;
	 
	 @ManyToOne
	 @JoinColumn(name="member_id")
	 private Member member;

	 
	 @ManyToOne
	 @JoinColumn(name="board_id")
	 private Board board;
	 
	 private LocalDateTime createdAt;
	 private LocalDateTime updatedAt;
}
