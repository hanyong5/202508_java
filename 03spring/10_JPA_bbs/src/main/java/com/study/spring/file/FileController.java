package com.study.spring.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileController {

	@Autowired
	FileService fileService;
	
	@Value("${file.upload-dir}")
	private String uploadDir;

	// postmain form-data / @ModelAttribute 자료전송 (이유 이미지파일)
	@PostMapping("/api/upload")
	public ResponseEntity<String> testFileUplad(
			@ModelAttribute TestDto req
			) throws IllegalStateException, IOException{
		
		
		fileService.fileCreate(req);
		return ResponseEntity.ok("SUCCESS");
	}
	
	@GetMapping("/api/image/{filename}")
	public ResponseEntity<Resource> getImage(
			@PathVariable("filename") String filename
			) throws IOException {
		File file = new File(uploadDir +"/" + filename); // c:/upload/filename
		
		if(!file.exists()) {
			log.info("파일없음");
			return ResponseEntity.notFound().build();
		}
		log.info("파일있음");
		
		Resource resource = new FileSystemResource(file);
		
		
		String contentType = Files.probeContentType(file.toPath());
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);
	}
	
	
	
	
	
	
	
	
}
