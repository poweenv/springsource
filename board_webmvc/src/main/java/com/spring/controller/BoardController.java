package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.domain.PageDTO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board")
@Controller
@Slf4j
public class BoardController {

	//전체 리스트 보여주기 컨트롤러 작성 : list.jsp 보여주기
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void listGet(Model model,Criteria cri) {
		log.info("전체 리스트 보여주기");
		//service.getList
		// 사용자가 요청한 번호에 맞는 게시물 목록 요청
		List<BoardDTO> list = service.getList(cri);
		//전체 게시물 숫자
		int total = service.getTotalCnt();
		
		model.addAttribute("list", list);
		model.addAttribute("pageDTO", new PageDTO(cri, total));
	}
	
	@GetMapping("/register")	
	public void registerGet() {
		log.info("게시글 폼 요청");
	}
	
	@PostMapping("/register")
	public String insert(BoardDTO dto,RedirectAttributes rttr) {
		log.info("게시글 작성");
		if(service.insert(dto)) {
			log.info(" 글 번호 :"+dto.getBno());
			rttr.addFlashAttribute("result", dto.getBno());
			return "redirect:/board/list";
		}
		return "redirect:/board/register";
	}
	//http://localhost:8080/board/read?bno=3
	//http://localhost:8080/board/modify?bno=3
	@GetMapping({"/read","/modify"})
	public void readGet(int bno,Model model) {
		log.info("게시글 조회 "+bno);
		
		//bno 해당하는 배용 가져오기
		BoardDTO dto = service.read(bno);
		model.addAttribute("dto", dto);
	}
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto,RedirectAttributes rttr) {
		log.info("modify ");
		
		rttr.addFlashAttribute("result", "수정이 완료되었습니다");
		if(service.modify(dto)) {
			return "redirect:/board/list";
			
		}
		return "/board/read";
	}

	@GetMapping("/remove")
	public String removeGet(int bno,RedirectAttributes rttr) {
		log.info("삭제"+ bno);
		service.remove(bno);
		
		rttr.addFlashAttribute("result", "삭제가 완료되었습니다");
		return "redirect:/board/list";
	}
	
	
}


