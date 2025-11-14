package com.study.spring.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Service
@Slf4j
public class FileService {
	
	@Autowired
	FileRepository fileRepository;

	@Value("${file.upload-dir}")
	private String uploadDir;

	public void fileCreate(TestDto req) throws IllegalStateException, IOException {
		log.info("title	: " + req.getTitle());
		log.info("title	: " + req.getContent());
		log.info("title	: " + req.getName());
		
		
		FileEntity createData = new FileEntity();
		createData.setName(req.getName());
		createData.setTitle(req.getTitle());
		createData.setContent(req.getContent());
		
		
		
		MultipartFile file = req.getFileUpload();
		
		if (file != null && !file.isEmpty()) {
			log.info("파일이 있네요. : " + file.getOriginalFilename());
			log.info("파일경로 : " + uploadDir);
			
			String originalFileName = file.getOriginalFilename();
			
			String newName = UUID.randomUUID() + "_" + originalFileName;

			//origin 파일업로드
			// 저장 폴더 없으면 생성
			File folder = new File(uploadDir);
			if (!folder.exists()) {
				folder.mkdirs();
				log.info("경로만듬");
			}
			// 저장경로 + 파일명
		     File saveFile = new File(folder,newName);
			
			// 저장
			file.transferTo(saveFile);
			
			
			// thumbnail 파일업로드
			String thumbnailName = "thumb_150_" + newName;
			File thumbnailFile = new File(folder,thumbnailName);
			Thumbnails.of(saveFile).size(150, 150).toFile(thumbnailFile);
			
			String thumbnailName1 = "thumb_200_" + newName;
			File thumbnailFile1 = new File(folder,thumbnailName1);
			Thumbnails.of(saveFile).size(200, 200).toFile(thumbnailFile1);
			
	
			
			createData.setImageFileName(newName);
		}
		
		fileRepository.save(createData);

	}

}