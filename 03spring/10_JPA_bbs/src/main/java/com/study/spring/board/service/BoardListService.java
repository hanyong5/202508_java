package com.study.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardListService {
	
	@Autowired
	BoardRepository boardRepository;

	public List<BoardListMemberDto> findWithMemberById() {
		return boardRepository.findWithMemberById();
	}

}
