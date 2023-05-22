package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;


public class MemberMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		MemberService service  = (MemberService)ctx.getBean("member");
			
			
		
		List<MemberDTO> list =service.getRows();
		for (MemberDTO memberDTO : list) {
			System.out.println(memberDTO);
		}
		
		
	}
	

}
