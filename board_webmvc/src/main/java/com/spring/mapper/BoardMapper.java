package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;

public interface BoardMapper {

	public List<BoardDTO> list(Criteria cri);
	public int insert(BoardDTO dto);
	public BoardDTO read(int bno);
	public int modify(BoardDTO dto);
	public int remove(int bno);
	public int totalCnt(Criteria cri);
	public int updateReplyCnt(@Param("bno") int bno,@Param("amount") int amount);
	
}
