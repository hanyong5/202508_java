package com.study.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.board.dto.BoardListDto;
import com.study.spring.board.dto.BoardListImageDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.service.BoardListService;
import com.study.spring.board.service.BoardService;

@RestController
public class BoardController {
	
//	@Autowired
//	BoardService boardService;
//	
//
//	@GetMapping("/api")
//	public String root() {
//		return "test";
//	}
//	
//	
//	// 전체리스트
//	@GetMapping("/api/board")
//	public List<Board> getBoardList(){
//		return boardService.getBoardList();
//	} 
//	
//	
//	// 페이징처리  reaquestparam page=0, size=10
//	@GetMapping("/api/boardpage")
//	public Page<Board> getBoardPageList(
//			@RequestParam(name ="page",defaultValue = "0") int page,
//			@RequestParam(name = "size",defaultValue = "10") int size
//			) {
//		
//		
//		return boardService.getBoardPageList(page,size);
//	}
// 
//	
//	
//	
//	@GetMapping("/api/boarddto")
//	public List<BoardListDto> getBoardListDto(){
//		return boardService.getBoardDto();
//	}
//	
//	@GetMapping("/api/board/{id}")
//	public Board getBoardView(
//			@PathVariable("id") Long id
//			) {
//		return boardService.getBoard(id);
//	}
//	
//	
//	//글작성
//	@PostMapping("/api/board")
//	public Board boardWrite(
//			@RequestBody Board request
//			) {
//		return boardService.boardWrite(request);
//	}
	
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardListService boardListService;
	
	
	//get,pagenation
	
	@GetMapping("/api/board")
	public List<BoardListMemberDto> boardList() {
		return boardListService.findWithMemberById();
	}
	
	@GetMapping("/api/boardi")
	public List<BoardListImageDto> boardListImage() {
		return boardListService.findWithImage();
	}
	
	// ~/api/boardp?page=0&size=10
	@GetMapping("/api/boardp")
	public Page<BoardListImageDto> boardListImagePage(
			@RequestParam(name="page",defaultValue = "0") int page,
			@RequestParam(name="size",defaultValue = "10") int size
			) {
		
//		Pageable pageable = PageRequest.of(page, size,Sort.by(Sort.Direction.DESC,"id"));
		Pageable pageable = PageRequest.of(page, size);
		return boardListService.findWithImagePage(pageable);
	}
	
	@GetMapping("/api/board/{id}")
	public BoardListImageDto boardListView(
			@PathVariable("id") Long id
			) {
		return boardListService.findWithImageById(id);
	}
	
	
	
	//post
	//update
	//delete
	
	
}
