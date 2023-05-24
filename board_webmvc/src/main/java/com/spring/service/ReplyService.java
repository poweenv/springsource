package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;

public interface ReplyService {

	public ReplyDTO reply(int rno);
	public boolean insert(ReplyDTO dto);
	public List<ReplyDTO> selReply(int bno,Criteria cri);
	public boolean update(ReplyDTO dto);
	public boolean delete(int rno);
}
