package com.study.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.board.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
