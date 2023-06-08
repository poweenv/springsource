package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookDTO;
import com.spring.domain.SearchDTO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/book")
@Slf4j
public class BookController{
	@Autowired
	private BookService service;
	
	
//	//insert.jsp 보여주기 => http://local:8080/book/insert + GET
//	@GetMapping("/insert")
//	public String insertForm() {
//		log.info("도서 정보 추가 폼 요청");
//		return "/product/insert";
//	}
//	//http://local:8080/book/insert + POST
//	@PostMapping("/insert")
//	public String insertPost(BookDTO dto) {
//		log.info("도서정보");
//		
//		try {
//		// 입력값 가져오기 - HttpServletRequest, 변수, ~DTO
//		// 서비스 작업
//		boolean insertFlag = service.insert(dto);
//		// 입력 성공 시 목록 보여주기
//		if(insertFlag) {
//			return "redirect:/book/list";
//		// 입력 실패 시 insert.jsp 보여주기
//		}else {
//			return "/product/insert";
//		}
//		} catch (Exception e) {
//			System.out.println("error");
//			return "/product/insert";	
//		}
//		
//	}
//	//http:localhost:8080/book/list + GET => list.jsp 보여주기
//	
//	@GetMapping("/list")
//	public String listForm(Model model) {
//		log.info("list 보여주기");
//		
//		// 사용자가 작성한 값 가져오기
//		// service 작업
//		List<BookDTO> list = service.getList();
//		// List 에 담긴 정보를 list.jsp에 보여주고 싶다면?
//		model.addAttribute("list",list);
//		return "/product/list";
//	}
//	//http:localhost:8080/book/read?code=? + GET
//	@GetMapping("/read")
//	public String readGet(int code, Model model) {
//		log.info("선택한 도서 정보");
//		
//		BookDTO dto= service.get(code);
//		model.addAttribute("dto", dto);
//		
//		return "/product/read";
//	}
	//insert.jsp 보여주기 => http://local:8080/book/insert + GET
		@GetMapping("/insert")
		public void insertForm() {
			log.info("도서 정보 추가 폼 요청");
			
		}
		//http://local:8080/book/insert + POST
		@PostMapping("/insert")
		public String insertPost(BookDTO dto) {
			log.info("도서정보");
			
			try {
				
				
			// 입력값 가져오기 - HttpServletRequest, 변수, ~DTO
			// 서비스 작업
			boolean insertFlag = service.insert(dto);
			// 입력 성공 시 목록 보여주기
			if(insertFlag) {
			// 입력 실패 시 insert.jsp 보여주기
				return "redirect:/book/list";
			}else {
				return "/book/insert";
			}	
			} catch (Exception e) {
				System.out.println("error");
				
				
				return "/book/insert";
			}
			
		}
		
		
		//http:localhost:8080/book/list + GET => list.jsp 보여주기
		
		@GetMapping("/list")
		public void listForm(Model model) {
			log.info("list 보여주기");
			
			// 사용자가 작성한 값 가져오기
			// service 작업
			List<BookDTO> list = service.getList();
			// List 에 담긴 정보를 list.jsp에 보여주고 싶다면?
			model.addAttribute("list",list);
			
		}
		
		//http:localhost:8080/book/read?code=? + GET
		@GetMapping({"/read","/modify"})
		public void readGet(int code, Model model) {
			log.info("선택한 도서 정보");
			
			BookDTO dto= service.get(code);
			model.addAttribute("dto", dto);
			// View Resolver 동작  http:localhost:8080/book/read  ==> WEB-INF/views/book/read.jsp
			// 					  http:localhost:8080/book/modify ==>			  /book/modify.jsp

		}
		
		// http:localhost:8080/book/modify?code=1002 =>book/update.jsp
//		@GetMapping("/modify")
//		public void modifyGet(int code, Model model) {
//			log.info("선택한 도서 정보");
//			
//			BookDTO dto= service.get(code);
//			model.addAttribute("dto", dto);
//
//		}
		
		@PostMapping("/modify")
		public String updatePost(BookDTO dto, RedirectAttributes rttr) {
			log.info("도서정보수정"+dto);
			
			try {
				
				boolean updateFlag = service.update(dto);
				
				rttr.addAttribute("code", dto.getCode());
				if (updateFlag) {
					return "redirect:/book/read";
				}else {
					return "/book/list";
				}
				
			} catch (Exception e) {
				
				System.out.println("catch");
				
				return "/book/modify";
			}
		}
		@GetMapping("/remove")
		public String remoceGet(int code) {
			log.info("book delete "+code);
			
			service.delete(code);
			
			return "redirect:/book/list";
		}
		
		// 사용자 입력 값 가져오기 => 변수 사용하는 방식
//		@GetMapping("/search")
//		public String searchGet(String criteria,String keyword,Model model) {
//			log.info("book search "+criteria+","+keyword);
//			
//			List<BookDTO> list = service.getList();
//			
//
//			
//			model.addAttribute("list", list);
//			return "/book/list";
//		}
		@GetMapping("/search")
		public String searchGet(SearchDTO search,Model model) {
			log.info("book search "+search);
			
			List<BookDTO> list = service.getSearchList(search.getCriteria(),search.getKeyword());
			

			
			model.addAttribute("list", list);
			model.addAttribute("searchDTO", search);
			return "/book/list";
		}
}
















