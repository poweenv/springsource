package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

	@Autowired
	private MemberMapper mapper;
	
	// /member/login
	
	@GetMapping("/login")
	public void MemberGet() {
		log.info("로그인 폼 요청");
		
		
	}
	@GetMapping("/login-error")
	public String LoginError(Model model) {
		log.info("loginError");
		
		model.addAttribute("error","아이디나 비밀번호를 확인해 주세요");
		
		return "/member/login";
	}
	@GetMapping("/admin")
	public void adminGet() {
		log.info("admin 요청");
		
	}
}
