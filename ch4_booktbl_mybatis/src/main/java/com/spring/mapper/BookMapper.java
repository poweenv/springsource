package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookDTO;

public interface BookMapper {

	
	//파라메터는 하나로 넘기는게 편함
	//여러개로 넘길때는 @Param() 어노테이션 사용
	public int insert(BookDTO dto);
	public int update(@Param("price") int price,@Param("code") int code);
	public int delete(int code);
	public BookDTO getRow(int code);
	public List<BookDTO> getRows();
}
