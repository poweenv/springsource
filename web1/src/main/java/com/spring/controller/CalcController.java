package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.AddDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CalcController {

	@GetMapping("/add")
	public void addForm() {
		log.info("add 요청");
	}
	
	// 사용자 입력값 가져오기
		// 1) HttpServletRequest 사용하기
		// 2) 변수 사용 : 1)변수명은 폼 태그 name 과 일치 2) 폼 태그 name 과 일치하지 않는다면 @RequestParam을 사용
		// 3) 바인딩 객체 사용
	
	@PostMapping("/add") // 바인딩 객체 사용 AddDTO 도메인에 만들어서 사용
	public String addPost(@ModelAttribute("add") AddDTO dto,@ModelAttribute("page") String page,Model model) {
		log.info("add post ..");
		log.info("num1 "+dto.getNum1());
		log.info("num2 "+dto.getNum2());
		log.info("page"+page);
		int result=dto.getNum1()+dto.getNum2();
		log .info("result "+result); 
		// => result 값을 result.jsp 에서 사용하고 싶다면?
		// ==> Model 객체 사용 == request.setAttribute()
		
		model.addAttribute("result",result);
		//model.addAttribute("page",page);
		
		return "result";
	}
//	@PostMapping("/add") // 바인딩 객체 사용 AddDTO 도메인에 만들어서 사용
//	public void addPost(AddDTO dto) {
//		log.info("add post ..");
//		log.info("num1 "+dto.getNum1());
//		log.info("num2 "+dto.getNum2());
//		log.info("result "+(dto.getNum1()+dto.getNum2()));
//	}
//	@PostMapping("/add")
//	public void addPost(int num1, int num2) {
//		log.info("add post ..");
//		log.info("num1 "+num1);
//		log.info("num2 "+num2);
//		log.info("result "+(num1+num2));
//	}
	
}
