package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.MemberDTO;

public interface MemberMapper {
	// () 안에 값들은 serviceImpl에서의 값과 같게 넣어준다
	public int insert(MemberDTO dto);
	public int delete(@Param("userid") String userid,@Param("password") String password);
	public int update(MemberDTO dto);
	public MemberDTO getRow(@Param("userid") String userid, @Param("password") String password);
	public List<MemberDTO> getRows();
}
