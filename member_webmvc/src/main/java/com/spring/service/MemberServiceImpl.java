package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorMatches;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	
	@Override
	public AuthDTO login(LoginDTO loginDTO) {
		//1234 ==> bPasswordEncoder.encode(1234) => 암호화 상태로 되지만 1234가 없어지고
		// 암호화된 코드만 남아 비밀번호가 바뀐 형태로 된다
		
		// matches(암호화하기 전, 암호화 코드)
		// matches(1234,db암호화된 문자)
		
		// 비밀번호가 일치하는가?
		// db에서 암호화된 비번 가져오기
		String encodePass=mapper.getPass(loginDTO.getUserid());
		if(bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.login(loginDTO.getUserid());
		}else {
			return null;
		}
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		// 비밀번호 암호화 : encode(암호화할 원본 코드)
		//				matches(암호화하기 전, 암호화 코드)
		//				1234(암호화되기전), 암호화된 코드
		memberDTO.setPassword(bPasswordEncoder.encode(memberDTO.getPassword()));
		return mapper.insert(memberDTO)==1?true:false;
	}

	@Override
	public boolean dupId(String userid) {
		
		// 0이라면 이미 userid가 없다는 것
		return mapper.dupId(userid)==0?true:false;
	}

	@Override
	public boolean remove(LoginDTO loginDTO) {

		String encodePass = mapper.getPass(loginDTO.getUserid());
		if (bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.leave(loginDTO.getUserid()) == 1 ? true : false;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(ChangeDTO changeDTO) {
		
		String encodePass = mapper.getPass(changeDTO.getUserid());
		// getUserid는 사용자가 입력한 userid 에 해당하는 비밀번호를 가져오려고 하는것
		// 그다음 가져온 값을 encodePass에 담아서 matches에서 비교해준다
		if(bPasswordEncoder.matches(changeDTO.getCurrentPassword(), encodePass)) {
			//변경 비밀번호 암호화
			return mapper.update(changeDTO)==1? true:false;
		}else {
		return false;
		}
	}

	
	
	
}
