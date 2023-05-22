package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardDTO;
import com.spring.service.BoardService;

public class BoardMain {

		public static void main(String[] args) {
			
			
			ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
			
			BoardService service = (BoardService) ctx.getBean("board");		
		
//			dto.setTitle("spring");
//			dto.setContent("spring framework");
//			dto.setWriter("java");
//			
//			boolean result = service.insertBoard(dto);
			
			
			
			
			BoardDTO dto= new BoardDTO();
//			dto.setBno(10);
//			dto.setTitle("스프링 개념");
//			dto.setContent("스프링 제어의 역전");
			boolean result =service.updateBoard(dto);
			System.out.println(result ? "complete" : "not complete");
//			
//			System.out.println(service.deleteBoard(2)?"success": "fail");
//			System.out.println(service.getRow(1));
			
//			List<BoardDTO> list = service.getRows();
//			for (BoardDTO boardDTO : list) {
//				System.out.println(boardDTO);
//			}
		}
}
