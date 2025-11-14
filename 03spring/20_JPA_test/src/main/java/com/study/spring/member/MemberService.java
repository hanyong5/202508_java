package com.study.spring.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	
public class MemberService {


	@Autowired
	MemberRepository memberRepository;

	public List<Member> getMemberList() {
		return memberRepository.findAll();
	}

	
}

