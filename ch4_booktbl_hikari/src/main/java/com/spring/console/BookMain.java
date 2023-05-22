package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookDTO;
import com.spring.persistence.BookDAO;
import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		//service 호출
		BookService service = (BookService) ctx.getBean("bookService");
		
		//도서 추가
///		BookDTO insertDto = new BookDTO(1258, "의적", "홍길동", 13300, "나는 의적이다");
//		if(service.insertBook(insertDto)) {
//			System.out.println("입력성공");
//		}
		
		//도서 수정
//		BookDTO updateDto = new BookDTO();
//		updateDto.setCode(1001);
//		updateDto.setPrice(12000);
//		if(service.updateBook(updateDto)) {
//			System.out.println("update");
//		}
//		
//		BookDTO row = service.getBook(1001);
//		System.out.println(row);
//		
//		if(service.deleteBook(1001)) {
//			System.out.println("delete complete");
//		}
		
		//전체 도서 목록 가져오기
//		BookService service = new BookServiceImpl(new BookDAO());
		List<BookDTO> list = service.getBookList();
		for (BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}
	}

}
