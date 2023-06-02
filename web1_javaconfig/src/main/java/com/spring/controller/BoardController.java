package com.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequestMapping("board")
public class BoardController {

	//@RequestMapping(value="/read", method=RequestMethod.GET)
	@GetMapping("/read")
	public void read() {
		log.info("read 요청");
		
	}
	//@RequestMapping(value="/register", method=RequestMethod.GET)
	@GetMapping("/register")
	public void register() {
		log.info("register 요청");

	}
	
	
	// Model == request.setAttribute()
	// 값을 유지시키기 위한 방법
	// RedirectAttributes : 
	// 1. addAttribute() - 일회성으로 데이터를 전달(객체 상태로 값 전달 불가)	
	// 2. addFlashAttribute() - 일회성으로 데이터를 전달(session을 사용함- 객체 상태로 전달 가능)
	// HttpSession
	
	//boardDTO
	// read 이동
//	@PostMapping("/register")
//	public String registerPost(BoardDTO dto, RedirectAttributes rttr) {
//		log.info("register 요청 " + dto);
//		
//		// BoardDTO 값이 유지가 되려면 forward 로 움직여야 함	
//		// BoardDTO 객체에 담긴 값을 read.jsp에서 사용하고 싶다면
////		rttr.addAttribute("name",dto.getName());
////		rttr.addAttribute("password",dto.getPassword());
////		rttr.addAttribute("title",dto.getTitle());
////		rttr.addAttribute("content",dto.getContent());
//		
//		rttr.addFlashAttribute("boardDTO", dto);
//		
//		return "redirect:/board/read";
//	}
	
	//@ModelAttribute("dto") : 괄호 부분은 생략 가능, Model 객체 대신 사용-model.addAttribute("",~~)대신 사용, 도메인 객체에 담을 때 이름 지정 가능
	// registerPost(BoardDTO dto) : jsp 페이지에서 값을 가져올 때  $(BoradDTO.name)
	// registerPost(@ModelAttribute("dto") BoardDTO dto) : jsp 페이지에서 값을 가져올 때 ${dto.name}
	
	@PostMapping("/register")
	public void registerPost(@ModelAttribute("dto")  BoardDTO dto, RedirectAttributes rttr) {
		log.info("dto 요청 " + dto);
//		BoardDTO 값이 유지가 되려면 forward 로 움직여야 함	

		
		
	}
	

//	@RequestMapping(value="/modify", method=RequestMethod.GET)
	@GetMapping("/modify")
	public void modify() {
		log.info("modify 요청");

	}
//	@RequestMapping(value="/remove", method=RequestMethod.GET)
	@GetMapping("remove")
	public void remove() {
		log.info("remove 요청");

	}
}
