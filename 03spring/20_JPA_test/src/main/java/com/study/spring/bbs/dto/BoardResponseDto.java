package com.study.spring.bbs.dto;

import java.time.LocalDateTime;

import com.study.spring.bbs.Board;
import com.study.spring.member.Member;

import lombok.Data;

@Data
public class BoardResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private String name;
	private String imageFileName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// Member 정보
	private Long memberId;
	private String memberName;
	private String memberEmail;
	
	public static BoardResponseDto from(Board board) {
		BoardResponseDto dto = new BoardResponseDto();
		dto.setId(board.getId());
		dto.setTitle(board.getTitle());
		dto.setContent(board.getContent());
		dto.setName(board.getName());
		dto.setImageFileName(board.getImageFileName());
		dto.setCreatedAt(board.getCreatedAt());
		dto.setUpdatedAt(board.getUpdatedAt());
		
		if (board.getMember() != null) {
			dto.setMemberId(board.getMember().getId());
			dto.setMemberName(board.getMember().getName());
			dto.setMemberEmail(board.getMember().getEmail());
		}
		
		return dto;
	}
	
}

