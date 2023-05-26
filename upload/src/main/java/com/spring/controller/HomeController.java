package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.FileDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@GetMapping("uploadForm")
	public void uploadForm() {
		log.info("fileupload");
		
	}
	// 첨부파일이 하나인 경우
//	@PostMapping("/uploadForm")
//	public void uploadPost(FileDTO dto) {
//		log.info("업로드"+dto);
//		
//		log.info("file Name:"+dto.getFile().getOriginalFilename());
//		log.info("contentType:"+dto.getFile().getContentType());
//		log.info("size :"+dto.getFile().getSize());
//		
//		String uploadPath="C:\\upload";
//		File saveFile = new File(uploadPath, dto.getFile().getOriginalFilename());
//		try {
//			dto.getFile().transferTo(saveFile);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	// 첨부 파일이 여러개인 경우
	@PostMapping("/uploadForm")
	public void uploadPost(FileDTO dto) {
		log.info("업로드"+dto);
		
		String uploadPath="C:\\upload";
		for (MultipartFile multipartFile : dto.getFile()) {
			
			log.info("file Name:"+multipartFile.getOriginalFilename());
			log.info("contentType:"+multipartFile.getContentType());
			log.info("size :"+multipartFile.getSize());
			
			UUID uuid=UUID.randomUUID();
			String fileName = uuid.toString() + "_"+multipartFile.getOriginalFilename();
			
			
			File saveFile = new File(uploadPath, fileName);
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	
}
