package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.domain.PersonDTO;
import com.spring.persistence.PersonDAO;

@Service("person")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO dao;
	
	@Override
	public boolean inserPerson(PersonDTO insert) {
		// TODO Auto-generated method stub
		return dao.insert(insert)==1?true:false;
	}

	@Override
	public boolean updatePerson(PersonDTO update) {
		// TODO Auto-generated method stub
		return dao.update(update)==1?true:false;
	}

	@Override
	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id)==1?true:false;
	}

	@Override
	public List<PersonDTO> getRows() {
		// TODO Auto-generated method stub
		return dao.getRows();
	}

	@Override
	public PersonDTO getRow(String id) {
		// TODO Auto-generated method stub
		return dao.getRow(id);
	}

}
