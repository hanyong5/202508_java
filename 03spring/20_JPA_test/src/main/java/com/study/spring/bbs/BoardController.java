package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.bbs.dto.BoardDto;
import com.study.spring.bbs.dto.BoardResponseDto;
import com.study.spring.comment.dto.CommentResponseDto;

@RestController
public class BoardController {


    @Autowired
    private BoardService boardService;

    //get방식으로 리스트
    // @GetMapping("/api/board")
    // public List<Board> getBoardList() {
    //     return boardService.getBoardList();
    // }


    //get방식으로 리스트 (페이징 + member 정보 포함)
    @GetMapping("/api/board")
    public Page<BoardResponseDto> getBoardList(
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        return boardService.getBoardList(pageable);
    }

    //post방식으로 글 작성
    @PostMapping("/api/board")
    public ResponseEntity<?> createBoard(@RequestBody BoardDto board) {
        return boardService.createBoard(board);
    }
    
    
    @GetMapping("/api/board/{boardId}/comments")
    public ResponseEntity<List<CommentResponseDto>> list(
    		@PathVariable("boardId") Long boardId
    		) {
    	return ResponseEntity.ok(boardService.list(boardId));
    }

}
