package com.study.spring.bbstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.bbs.Bbs;
import com.study.spring.bbs.BbsRepository;

@SpringBootTest
public class BbsTest {

	@Autowired
	public BbsRepository bbsReop;
	
	@Test
	public void bbsInsert() {
		
		
//	  for(int i=1;i<=3;i++) {
//		  
		  Bbs bbs = new Bbs();
		  bbs.setName("이름11");
		  bbs.setTitle("안녕하세요11");
		  bbs.setContent("안녕, 만나서 반가와");
		  
		  bbsReop.save(bbs);
//	  }
		

//		bbsReop.save(bbs);
		
//		Bbs bbs1 = Bbs.builder()
//				.name("이순신2")
//				.title("만나2")
//				.content("하이2")
//				.build();
//		
//		bbsReop.save(bbs1);
		
	}
}
