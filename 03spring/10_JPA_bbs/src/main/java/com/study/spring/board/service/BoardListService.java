package com.study.spring.board.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.board.dto.BoardListImageDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.dto.ImageDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.entity.Image;
import com.study.spring.board.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
// Page<>.map(()->{});
// dto.builder().build();
		
		
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

	public Page<BoardListImageDto> findWithImagePage(Pageable pageable) {

		//entity
		Page<Board> page = boardRepository.findWithImagePage(pageable);
		
		
		//return entity -> dto - json
		return page.map(
				p -> BoardListImageDto.builder()
				.id(p.getId())
				.title(p.getTitle())
				.content(p.getContent())
				.memberName(p.getMember().getName())
				.memberEmail(p.getMember().getEmail())
				.createdAt(p.getCreatedAt())
				.images(p.getImages().stream()
						.map(
								img -> new ImageDto(
										img.getId(),
										img.getImageOrder(),
										img.getFileName()
										)
								)
						.toList())
				.build()
				);
	}

	public BoardListImageDto findWithImageById(Long id) {
		
		//entity 
		Board b = boardRepository.findWithImageById(id);
		
		
		
		//entity -> dto
		return BoardListImageDto.builder()
				.id(b.getId())
				.title(b.getTitle())
				.content(b.getContent())
				.memberName(b.getMember().getName())
				.memberEmail(b.getMember().getEmail())
				.createdAt(b.getCreatedAt())
				.imageCount(b.getImages().size())
				.images(b.getImages().stream()
//						.sorted(Comparator.comparing(image -> image.getImageOrder()))
						.sorted(Comparator.comparing(Image::getImageOrder).reversed())
						.map(
								img -> new ImageDto(
										img.getId(),
										img.getImageOrder(),
										img.getFileName()
										)
								)
						.toList())
				.build();
	}


	
	

	
	
	
	
	
	

}
