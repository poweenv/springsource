package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginDTO;
import com.spring.domain.RegisterDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	
	//get + post 둘다 응답 requestMapping 을 했을 땨
	//@RequestMapping("/login")
	
	// 사용자 입력값 가져오기
	// 1) HttpServletRequest 사용하기
	// 2) 변수 사용 : 1)변수명은 폼 태그 name 과 일치 2) 폼 태그 name 과 일치하지 않는다면 @RequestParam을 사용
	// 3) 바인딩 객체 사용
	
	//1)
	// 둘다 응답 하지 않게 하려면 value,method 를 지정해준다
	//@RequestMapping(value="/login", method= RequestMethod.GET)
	@GetMapping("/login")
	public void loginGet(HttpServletRequest req) {
		log.info("login...");
		log.info("method "+req.getMethod());
						// return 이 있던 없던 viewResolver가 돈다
						// WEB-INF/views/login.jsp를 붙인다
		
	}
	//@RequestMapping(value="/login", method= RequestMethod.POST)
//	@GetMapping("/login")
//	public void loginPost(HttpServletRequest req) {
//		log.info("login post...");
//		log.info("method "+req.getMethod());
//		// return 이 있던 없던 viewResolver가 돈다
//		// WEB-INF/views/login.jsp를 붙인다
//		System.out.println("id " +req.getParameter("id"));
//		System.out.println("password " +req.getParameter("password"));
//	}
	
	// 2)
//	@PostMapping("/login")
//	public void loginPost(String id, String password) {
//		log.info("login post...");
//		// return 이 있던 없던 viewResolver가 돈다
//		// WEB-INF/views/login.jsp를 붙인다
//		System.out.println("id " +id);
//		System.out.println("password " +password);
//	}
	@PostMapping("/login")
	public String loginPost(LoginDTO dto) {
		log.info("login post...");
		// return 이 있던 없던 viewResolver가 돈다
		// WEB-INF/views/login.jsp를 붙인다
		System.out.println("id " +dto.getId());
		System.out.println("password " +dto.getPassword());
		return "/member/main";
	}
	
	
	
	//@RequestMapping("/register")
	@GetMapping("/register")
	public void RegisterGet() {
		log.info("register...");
	//	return "/member/register"; //리턴이 있다면  /WEB-INF/views/register.jsp
		
		//member/register + POST 처리
		// DTO 작성
		// 사용자 입력값 잘들어왔는지 확인
		// login.jsp 보여주기
		
	}
	@PostMapping("/register")
	public String registerPost(RegisterDTO dto) {
		log.info("회원가입 요청");
		log.info(dto.toString());
		
		
		// redirect: 붙게 되면 viewResolver가 아닌 DisaptcherServlet 이 동작
		// == response.sendRedirect()
		// forward 는 아무것도 붙여주지 않으면 자동으로 붙게된다.
		// http://localhost:8080/member/login + GET 요청
		return "redirect:/member/login";
	}
	
}






















