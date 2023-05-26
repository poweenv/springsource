package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	@Autowired
	private ReplyMapper reMapper;
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public ReplyDTO reply(int rno) {
		return reMapper.reply(rno);
	}

	@Transactional //2개의 작업이 진행될때 하나의 작업으로 인식하게하는거
	@Override
	public boolean insert(ReplyDTO dto) {
		//댓글 수 추가
		mapper.updateReplyCnt(dto.getBno(), 1);
		//댓글 등록
		return reMapper.insert(dto)==1?true:false;
	}

	@Override
	public ReplyPageDTO selReply(int bno,Criteria cri) {
		List<ReplyDTO> list=reMapper.selReply(bno,cri);
		int replyCnt = reMapper.getCountBno(bno);
		return new ReplyPageDTO(replyCnt, list);
	}

	@Override
	public boolean update(ReplyDTO dto) {
		
		return reMapper.update(dto)==1?true:false;
	}

	@Override
	public boolean delete(int rno) {
		//댓글 수 차감
		ReplyDTO dto = reMapper.reply(rno);
		mapper.updateReplyCnt(dto.getBno(), -1);
		return reMapper.delete(rno)==1?true:false;
	}

}

