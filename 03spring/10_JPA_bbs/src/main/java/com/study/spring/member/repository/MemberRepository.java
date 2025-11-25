package com.study.spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
