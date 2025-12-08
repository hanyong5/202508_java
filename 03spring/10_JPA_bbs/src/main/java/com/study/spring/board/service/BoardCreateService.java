package com.study.spring.board.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.spring.board.dto.BoardCreateDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.entity.Image;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.repository.ImageRepository;
import com.study.spring.member.entity.Member;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Service
@Slf4j
@Transactional
public class BoardCreateService {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	
	@Value("${file.upload-dir}")
	private String uploadDir;




	public Long boardCreateData(BoardCreateDto req) {
		log.info("title	: " + req.getTitle());
		log.info("content	: " + req.getContent());
		log.info("member id	: " + req.getMemberId());
		log.info("file	: " + req.getFileUploads());
		



	// INSERT_YOUR_CODE

	// 1. 파일 확인 및 처리
	if (req.getFileUploads() != null && !req.getFileUploads().isEmpty()) {
	    // Board Entity 생성
	    Board board = new Board();
	    board.setTitle(req.getTitle());
	    board.setContent(req.getContent());

	    // 간단히 memberId로 Member를 set하는 경우 (실제 프로젝트에서는 memberRepository 등으로 find 필요)
	    Member member = new Member();
	    member.setId(req.getMemberId());
	    board.setMember(member);

	    // 파일 저장 - 파일명에 UUID 부여
	    List<Image> images = new ArrayList<>();
		int i = 0;
	    for (MultipartFile file : req.getFileUploads()) {
	        if (!file.isEmpty()) {
	            String uuid = java.util.UUID.randomUUID().toString();
	            String originalFileName = file.getOriginalFilename();
	            String ext = "";
	            if (originalFileName != null && originalFileName.lastIndexOf('.') > -1) {
	                ext = originalFileName.substring(originalFileName.lastIndexOf('.'));
	            }
	            String fileName = uuid + "_" + originalFileName;


			    //파일저장

	            // INSERT_YOUR_CODE
	            // 첫번째 이미지만 썸네일 처리
	           

	            File uploadPath = new File(uploadDir);
	            if (!uploadPath.exists()) {
	                uploadPath.mkdirs();
	            }

 				File dest = new File(uploadPath, fileName);
	            try {
	                file.transferTo(dest);
	                // 첫번째 이미지만 썸네일 생성
	                if (i == 0) {
	                    String thumbnailName = "thumb_" + fileName;
	                    File thumbnailFile = new File(uploadPath, thumbnailName);
	                    Thumbnails.of(dest)
	                        .size(150, 150)
	                        .toFile(thumbnailFile);
	                }
	            } catch (Exception e) {
	                log.error("파일 업로드 또는 썸네일 생성 실패: " + e.getMessage());
	                throw new RuntimeException("파일 업로드 또는 썸네일 생성 실패", e);
	            }

	           

				

	            // Image Entity 생성
				
	            Image image = new Image();
	            image.setFileName(fileName);
				image.setImageOrder(i);
	            image.setOriginalFileName(originalFileName);
	            image.setBoard(board);
	            images.add(image);
				i++;
	        }
	    }
	    board.setImages(images);


	    // 저장 (Cascade 옵션에 따라 이미지는 board 저장시 같이 저장될 수 있음)
	    Board savedBoard = boardRepository.save(board);
		imageRepository.saveAll(images);
		log.info("board created successfully with id: " + savedBoard.getId());
		return savedBoard.getId();
	} else {
		// 파일이 없는 경우에도 Board 생성
		Board board = new Board();
		board.setTitle(req.getTitle());
		board.setContent(req.getContent());
		
		Member member = new Member();
		member.setId(req.getMemberId());
		board.setMember(member);
		
		Board savedBoard = boardRepository.save(board);
		log.info("board created successfully with id: " + savedBoard.getId());
		return savedBoard.getId();
	}
	}
}
