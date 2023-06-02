package com.spring.service;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;

public interface ReplyService {

	public ReplyDTO reply(int rno);
	public boolean insert(ReplyDTO dto);
	// 댓글 목록만 처리
	//public List<ReplyDTO> selReply(int bno,Criteria cri);
	//댓글 총 수 ,댓글 목록 처리
	public ReplyPageDTO selReply(int bno,Criteria cri);
	public boolean update(ReplyDTO dto);
	public boolean delete(int rno);

}
