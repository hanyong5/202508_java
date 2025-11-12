package com.study.spring.file;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileController {

	@Value("${file.upload-dir}")
	private String uploadDir;

	@PostMapping("/api/upload")
	public ResponseEntity<String> testFileUplad(@ModelAttribute TestDto req) throws IllegalStateException, IOException{
		log.info("title	: " + req.getTitle());
		log.info("title	: " + req.getContent());
		log.info("title	: " + req.getName());

		MultipartFile file = req.getFileUpload();
		if (file != null && !file.isEmpty()) {
			log.info("파일이 있네요. : " + file.getOriginalFilename());
			log.info("파일경로 : " + uploadDir);
			
			String originalFileName = file.getOriginalFilename();
			

			// 저장 폴더 없으면 생성
			File folder = new File(uploadDir);
			if (!folder.exists()) {
				folder.mkdirs();
				log.info("경로만듬");
			}
			
			// 저장경로 + 파일명
			File saveFile = new File(folder,originalFileName);
			
			// 저장
			file.transferTo(saveFile);

		}
		
		return ResponseEntity.ok("SUCCESS");
	}
}
