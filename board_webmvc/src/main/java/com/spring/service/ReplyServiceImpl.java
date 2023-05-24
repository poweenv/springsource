package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	@Autowired
	private ReplyMapper reMapper;
	
	@Override
	public ReplyDTO reply(int rno) {
		// TODO Auto-generated method stub
		return reMapper.reply(rno);
	}

	@Override
	public boolean insert(ReplyDTO dto) {
		return reMapper.insert(dto)==1?true:false;
	}

	@Override
	public List<ReplyDTO> selReply(int bno,Criteria cri) {
		
		return reMapper.selReply(bno,cri);
	}

	@Override
	public boolean update(ReplyDTO dto) {
		
		return reMapper.update(dto)==1?true:false;
	}

	@Override
	public boolean delete(int rno) {
		
		return reMapper.delete(rno)==1?true:false;
	}

}
