package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
