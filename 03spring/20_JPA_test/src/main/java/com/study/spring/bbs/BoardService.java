package com.study.spring.bbs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.study.spring.member.Member;
import com.study.spring.member.MemberRepository;

@Service	
public class BoardService {


	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
//	 public List<Board> getBoardList() {
//	        return boardRepository.findAll();

	public Page<BoardResponseDto> getBoardList(Pageable pageable) {
		Page<Board> boardPage = boardRepository.findAll(pageable);
		return boardPage.map(BoardResponseDto::from);
	}

	public ResponseEntity<?> createBoard(BoardDto boardDto) {
		if (boardDto.getMemberId() == null) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "memberId is required");
			error.put("message", "회원 ID가 필요합니다.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
		Member member = memberRepository.findById(boardDto.getMemberId())
				.orElse(null);
		
		if (member == null) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "Member not found");
			error.put("message", "해당 ID의 회원을 찾을 수 없습니다: " + boardDto.getMemberId());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
		
		Board board = new Board();
		board.setTitle(boardDto.getTitle());
		board.setContent(boardDto.getContent());
		board.setName(boardDto.getName());
		board.setImageFileName(boardDto.getImageFileName());
		board.setMember(member);
		
		Board savedBoard = boardRepository.save(board);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
	}

	
}
