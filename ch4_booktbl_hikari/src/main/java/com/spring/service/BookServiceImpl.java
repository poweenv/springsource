package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookDTO;
import com.spring.persistence.BookDAO;


@Service("bookService") 
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	
	/*
	 * public BookServiceImpl(BookDAO bookDAO) { this.bookDAO = bookDAO; }
	 */
	@Override
	public boolean insertBook(BookDTO insertDto) {
		
		return bookDAO.insert(insertDto);
	}

	@Override
	public boolean updateBook(BookDTO updateDto) {
		// TODO Auto-generated method stub
		return bookDAO.update(updateDto);
	}

	@Override
	public boolean deleteBook(int code) {
		// TODO Auto-generated method stub
		return bookDAO.delete(code);
	}

	@Override
	public BookDTO getBook(int code) {
		// TODO Auto-generated method stub
		return bookDAO.getRow(code);
	}

	@Override
	public List<BookDTO> getBookList() {
		
		return bookDAO.getRows();
	}

}
