package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;

@Mapper
public interface ReplyMapper {

	public ReplyDTO reply(int rno);
	public int insert(ReplyDTO dto);
	public List<ReplyDTO> selReply(@Param("bno") int bno,@Param("cri") Criteria cri);
	public int getCountBno(int bno);
	public int update(ReplyDTO dto);
	public int delete(int rno);
	public int deleteAll(int bno);
}
