package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.spring.domain.PersonDTO;

public interface PersonMapper {

	
// interface + 어노테이션
//	@Insert("insert into person(id,name) values(#{id}, #{name})")
//	public int insert(PersonDTO insert);
	
	//interface + XML
	// 메소드명과 XML 에 작성한 id 명이 일치해야 함 -엄청중요
	// PersonMapper.xml에서 namespace 맞추기
	public int insertPerson(PersonDTO insert);
	public int updatePerson(PersonDTO insert);
	public int deletePerson(String id);
	public PersonDTO selectOne(String id);
	public List<PersonDTO> selectAll();
	
}
