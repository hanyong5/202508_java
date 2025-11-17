package com.study.spring.comment.dto;

import java.time.LocalDateTime;

import com.study.spring.comment.Comment;

import lombok.Data;

@Data
public class CommentResponseDto {
	
	private Long id;
	private String comment;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// Member 정보
	private Long memberId;
	private String memberName;
	private String memberEmail;
	
	// Board 정보 (선택적)
	private Long boardId;
	
	public static CommentResponseDto from(Comment comment) {
		return from(comment, null);
	}
	
	public static CommentResponseDto from(Comment comment, Long boardId) {
		CommentResponseDto dto = new CommentResponseDto();
		dto.setId(comment.getId());
		dto.setComment(comment.getComment());
		dto.setCreatedAt(comment.getCreatedAt());
		dto.setUpdatedAt(comment.getUpdatedAt());
		
		if (comment.getMember() != null) {
			dto.setMemberId(comment.getMember().getId());
			dto.setMemberName(comment.getMember().getName());
			dto.setMemberEmail(comment.getMember().getEmail());
		}
		
		// boardId를 파라미터로 받거나, comment의 board에서 가져오기
		if (boardId != null) {
			dto.setBoardId(boardId);
		} else if (comment.getBoard() != null) {
			dto.setBoardId(comment.getBoard().getId());
		}
		
		return dto;
	}
	
}

