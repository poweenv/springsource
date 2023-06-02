package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.mapper.AttachMapper;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Autowired
	private AttachMapper attachMapper;
	
	@Autowired
	private ReplyMapper reMapper;
	
	@Override
	public List<BoardDTO> getList(Criteria cri) {	
		return mapper.list(cri);
	}
	
	@Transactional
	@Override
	public boolean insert(BoardDTO dto) {		
		// board 테이블 + attach 테이블 등록
		
		boolean insertFlag= mapper.insert(dto)==1?true:false;
		// 첨부파일이 유뮤를 확인
		if(dto.getAttachList() == null|| dto.getAttachList().size()==0) {
			return insertFlag;
		}
		
		dto.getAttachList().forEach(attach->{
			attach.setBno(dto.getBno());
			attachMapper.insert(attach);
		});		
		return insertFlag;
	}

	@Override
	public BoardDTO read(int bno) {		
		
//		BoardDTO dto=mapper.readAttach(bno);
//		log.info("상세 + 파일첨부"+dto);
		
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(BoardDTO dto) {		
		boolean updateFlag= mapper.modify(dto)==1?true:false;
		
		// 기존 첨부목록 제거
		attachMapper.deleteAll(dto.getBno());
		
		//첨부파일이 있다면
		if(dto.getAttachList() == null|| dto.getAttachList().size()==0) {
			return updateFlag;
		}
		//첨부목록 삽입
		dto.getAttachList().forEach(attach->{
			attach.setBno(dto.getBno());
			attachMapper.insert(attach);
		});	
		
		return updateFlag;
	}

	@Transactional
	@Override
	public boolean remove(int bno) {
		
		//자식 댓글 삭제
		reMapper.deleteAll(bno);
		
		//첨부파일 삭제
		attachMapper.deleteAll(bno);
		return mapper.remove(bno)==1?true:false;
	}


	@Override
	public int getTotalCnt(Criteria cri) {
		
		return mapper.totalCnt(cri);
	}

	@Override
	public List<AttachFileDTO> getAttachList(int bno) {
		// TODO Auto-generated method stub
		return attachMapper.select(bno);
	}


	

}
