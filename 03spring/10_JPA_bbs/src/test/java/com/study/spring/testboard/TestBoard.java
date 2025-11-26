package com.study.spring.testboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.board.entity.Board;
import com.study.spring.board.entity.Image;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.repository.ImageRepository;
import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TestBoard {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	ImageRepository imageRepository;

//	@Test
//	public void insertBoard() {
//		Member member = memberRepository.findById(1L)
//				.orElseThrow(()-> new IllegalArgumentException("멤버가 없어요"));
////		
////		Board board = new Board();
////			board.setTitle("안녕하세요1");
////			board.setContent("만나서반값습니다.1");
////			board.setName("홍길동");
////			board.setMember(member);
//		
//		
//		Board board = Board.builder()
//				.title("안녕1")
//				.content("내용1")
//				.name("이순신1")
//				.member(member)
//				.build();
//			
//		Board saveBoard= boardRepository.save(board);
//		log.info("글작성" + saveBoard);
//		log.info("아이디" + member);
//	}

//	@Test
//	public void insertImage() {
//		Board board = boardRepository.findById(19L)
//				.orElseThrow(() -> new IllegalArgumentException("데이터가 없어요"));
//	
//		Image img1 = Image.builder()
//				.originalFileName("cat2.jpg")
//				.fileName("cat2_.jpg")
//				.board(board)
//				.build();
//		
//		Image saveImage = imageRepository.save(img1);
//		
//		log.info("글보기 : " + board);
//		log.info("저장 : " + saveImage);
//		
//		log.info("저장된 이미지 id={}", saveImage.getId());
//		log.info("저장된 파일명 ={}", saveImage.getOriginalFileName());
//	
//	
//	
//	}
	
		@Test
		public void getImageList() {
			Board board = boardRepository.findById(19L)
			.orElseThrow(() -> new IllegalArgumentException("데이터가 없어요"));
			
			System.out.println("======게시물정보=======");
			System.out.println("id : " + board.getId());
			System.out.println("title : " + board.getTitle());
			System.out.println("=======이미지==========");
			
			
			board.getImages().forEach(img -> {
				System.out.println("이미지 id : " + img.getId());
				System.out.println("파일명 : " + img.getOriginalFileName());
				System.out.println("순서 : " + img.getImageOrder());
				System.out.println("===================");
				
			});
			

		}
	

}
