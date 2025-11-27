package com.study.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.board.dto.BoardListImageDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.dto.ImageDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardListService {
	
	@Autowired
	BoardRepository boardRepository;

	public List<BoardListMemberDto> findWithMemberById() {
		return boardRepository.findWithMemberById();
	}

	public List<BoardListImageDto> findWithImage() {
		
		//entity
		List<Board> boards = boardRepository.findWithImage();
		
//		return boards.stream()
//				.map(b->BoardListImageDto
//						.builder()
//						.title(b.getTitle())
//						.memberName(b.getMember().getName())
//						.memberEmail(b.getMember().getEmail())
//						.content(b.getContent())
//						.createdAt(b.getCreatedAt())
//						.images(null)
//						.build())
//				.toList();
		
// boards.stream().map(()->{}).toList();
// Page<>.stream().map(()->{});		
		
		
		return boards.stream()
				.map(b->BoardListImageDto
						.builder()
						.title(b.getTitle())
						.memberName(b.getMember().getName())
						.memberEmail(b.getMember().getEmail())
						.content(b.getContent())
						.createdAt(b.getCreatedAt())
						.images(b.getImages().stream()
								.map(img -> new ImageDto(
										img.getId(),
										img.getImageOrder(),
										img.getFileName()
										))
								.toList())
						.build())
				.toList();
	}

	
	
	
	
	
	
	
	
	
	
	

}
