package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.domain.PersonDTO;
import com.spring.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper mapper;
	
	@Override
	public boolean inserPerson(PersonDTO insert) {
		// TODO Auto-generated method stub
		return mapper.insertPerson(insert)==1?true:false;
	}

	@Override
	public boolean updatePerson(PersonDTO update) {
		// TODO Auto-generated method stub
		return mapper.updatePerson(update)==1?true:false;
	}

	@Override
	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return mapper.deletePerson(id)==1?true:false;
	}

	@Override
	public List<PersonDTO> getRows() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public PersonDTO getRow(String id) {
		// TODO Auto-generated method stub
		return mapper.selectOne(id);
	}

}
