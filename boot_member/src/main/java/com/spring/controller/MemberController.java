package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService service;

	// login.jsp 보여주는 컨트롤러
	@GetMapping("/login")
	public void loginGet() {
		log.info("login complete");

	}

	@PostMapping("/login")
	public String loginPost(LoginDTO loginDTO, HttpSession session) {
		log.info("로그인" + loginDTO);

		AuthDTO authDTO = service.login(loginDTO);

		if(authDTO!=null) {
			
			session.setAttribute("authDTO", authDTO);
			return "redirect:/";
		}else {
			return "redirect:/member/login";
		}

	}

	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("로그 아웃");
		session.removeAttribute("authDTO");
		return "redirect:/";
	}

	@GetMapping("/step1")
	public void stepGet() {
		log.info("약관페이지 보여주기");
	}

	// 약관동의 여부
	@PostMapping("/step1")
	public String stepPost(boolean agree, RedirectAttributes rttr) {
		log.info("약관동의 " + agree);

		// true인 경우 register.jsp보여주기
		//
		if (agree)
			return "/member/register";
		else {
			rttr.addFlashAttribute("check", false);
			// return "redirect:/member/step1";
			return "/member/step1";

		}

	}

	@PostMapping("/register")
	public String registerPost(MemberDTO dto) {
		log.info("회원가입 요청" +dto);

		// 회원가입 성공시 로그인 페이지 이동
		if(service.insert(dto)) {
			return "redirect:/member/login";
		}else {
		return "/member/register";
		}
	}
	
	@PostMapping("/dupId")
	@ResponseBody // 컨트롤러 작업이 완료될때 결과값으로 리턴
	public String dupIdCheck(String userid) {
		log.info("아이디 중복 확인 "+userid);
		boolean idCheck = service.dupId(userid);
		
		if(idCheck) {
			return "true"; // veiwResolver가 돌면서  /WEB-INF/views/true.jsp
		}else {
			return "false"; // veiwResolver가 돌면서  /WEB-INF/views/false.jsp
		}
			
		
	}
	
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("회원 탈퇴 페이지 요청");
	}
	
	
	@PostMapping("/leave")
	public String leavePost(LoginDTO loginDTO,HttpSession session) {
		log.info("회원 탈퇴 성공 "+ loginDTO);
		
		if(service.remove(loginDTO)) {
			session.invalidate();
			return "redirect:/";
		}
		return "redirect:/member/leave";
	}
	
	@GetMapping("/changePwd")
	public void changePwdGet() {
		log.info("비밀번호 변경 페이지 요청 ");
		
	}
	@PostMapping("/changePwd")
	public String changePwdPost(ChangeDTO changeDTO, HttpSession session) {
		log.info("비밀번호 변경 "+changeDTO);
		
		if(changeDTO.passwordEquals()) {
			
			// 현재 비밀번호 일치여부 확인
			// true : 비밀번호 변경 ==> session 제거 ==> login페이지 보여주기
			// false : 회원탈퇴 페이지로
			if(service.update(changeDTO)) {
				session.invalidate();
				return "redirect:/member/login";
			}
		}
		
		return "redirect:/member/changePwd";
		
	}
}




















