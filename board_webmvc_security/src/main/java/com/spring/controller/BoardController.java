package com.spring.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.domain.PageDTO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board")
@Controller
@Slf4j
public class BoardController {

	@Autowired
	private BoardService service;
	
	//전체 리스트 보여주기 컨트롤러 작성 : list.jsp 보여주기
	@GetMapping("/list")
	public void listGet(Model model,@ModelAttribute("cri") Criteria cri) {
//		log.info("전체 리스트 보여주기");
//		log.info("type"+Arrays.toString(cri.getTypeArr()));
		//service.getList
		// 사용자가 요청한 번호에 맞는 게시물 목록 요청
		List<BoardDTO> list = service.getList(cri);
		//전체 게시물 숫자
		int total = service.getTotalCnt(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("pageDTO", new PageDTO(cri, total));
	}
	
	@GetMapping("/register")	
	public void registerGet() {
//		log.info("게시글 폼 요청");
	}
	
	@PostMapping("/register")
	public String insert(BoardDTO dto,RedirectAttributes rttr,Criteria cri) {
	
		
//		log.info("게시글 작성");
		
//		// 첨부ㅏㅍ일 확인
//		if(dto.getAttachList()!= null) {
//			dto.getAttachList().forEach(attach->log.info(attach.toString()));
//		}
		
		
		
		if(service.insert(dto)) {
	//		log.info(" 글 번호 :"+dto.getBno());
			rttr.addFlashAttribute("result", dto.getBno());
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("amount", cri.getAmount());

			return "redirect:/board/list";
		}
		return "redirect:/board/register";
	}
	//http://localhost:8080/board/read?bno=3
	//http://localhost:8080/board/modify?bno=3
	@GetMapping({"/read","/modify"})
	public void readGet(int bno,Model model,@ModelAttribute("cri") Criteria cri) {
//		log.info("게시글 조회 "+bno);
		
		//bno 해당하는 배용 가져오기
		BoardDTO dto = service.read(bno);
		model.addAttribute("dto", dto);
	}
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto,RedirectAttributes rttr,Criteria cri) {
//		log.info("modify ");
		
		rttr.addFlashAttribute("result", "수정이 완료되었습니다");
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("page", cri.getPage());
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		if(service.modify(dto)) {
			return "redirect:/board/list";
		}
		return "/board/read";
	}

	@GetMapping("/remove")
	public String removeGet(int bno,RedirectAttributes rttr, Criteria cri) {
	//	log.info("삭제"+ bno);
		
		List<AttachFileDTO> attachList = service.getAttachList(bno);
		deleteAttachFiles(attachList);
		
		service.remove(bno);
		
		rttr.addFlashAttribute("result", "삭제가 완료되었습니다");
		// 페이지 나누기 정보 주소줄에 같이 보내기
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("page", cri.getPage());
		// 검색 정보 주소줄에 보내기
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}
	
	//첨부파일 가져오기 + GET +bno
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> attachList(int bno) {		
		List<AttachFileDTO> attachList = service.getAttachList(bno);
		
		return attachList !=null? new ResponseEntity<List<AttachFileDTO>>(attachList,HttpStatus.OK):
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	private void deleteAttachFiles(List<AttachFileDTO> attachList) {
		log.info("첨부 파일 폴더에서 제거");
		
		if(attachList ==null || attachList.size() <=0) return;
		
		for (AttachFileDTO dto : attachList) {
			// 파일 경로
			Path path = Paths.get("c:\\upload\\"+dto.getUploadPath()+"\\"+dto.getUuid()+"_"+dto.getFileName());
			
			try {
				Files.deleteIfExists(path);
				
				// 이미지 파일인 경우 썸네일 제거
				if(Files.probeContentType(path).startsWith("image")) {
					Path thumb = Paths.get("c:\\upload\\"+ dto.getUploadPath()+"\\s_"+dto.getUuid()+"_"+dto.getFileName());
					Files.deleteIfExists(thumb);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}









