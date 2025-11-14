package com.study.spring.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {


    @Autowired
    private MemberService memberService;

    //get방식으로 리스트
    @GetMapping("/api/member")
    public List<Member> getMemberList() {
        return memberService.getMemberList();
    }

}

