package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring.bean.Config;
import com.study.spring.bean.Member;




//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		Member member1 = (Member) context.getBean("member1");
		member1.print();
		
		
		
		
		
	}

}
