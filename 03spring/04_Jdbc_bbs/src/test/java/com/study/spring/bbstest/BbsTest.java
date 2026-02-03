package com.study.spring.bbstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.bbs.BbsDTO;
import com.study.spring.bbs.IBbsDAO;

@SpringBootTest
public class BbsTest {
	 @Autowired
	    private IBbsDAO iBbsDAO;

	    @Test
	    void textDataInsertTest() {
	        BbsDTO dto = new BbsDTO();
	        dto.setWriter("관리자");
	        dto.setTitle("첫 번째 게시글");
	        dto.setContent("스프링 부트 테스트에서 입력한 내용입니다.");

	        int result = iBbsDAO.writeDAO(dto);

	        System.out.println("insert 결과 = " + result);
	    }
}
