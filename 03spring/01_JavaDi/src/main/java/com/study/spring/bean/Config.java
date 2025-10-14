package com.study.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Member member1() {
		Member member1 = new Member();
		member1.setName("hong");
		member1.setNickname("도사");
		member1.setPrinter(new PrinterA());
		
		return member1;
	}
}
