package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonDTO;
import com.spring.service.PersonService;

public class PersonMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		
		PersonService service=(PersonService) ctx.getBean("person");
		
//		PersonDTO insertPerson = new PersonDTO("choi23333","coiiio");
//		System.out.println(service.inserPerson(insertPerson)? "성공":"실패");
		
		
		List<PersonDTO> list = service.getRows();
		for (PersonDTO personDTO : list) {
			System.out.println(personDTO);
		}
	
	// 수정
	}	

}
