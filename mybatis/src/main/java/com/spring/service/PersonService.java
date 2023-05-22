package com.spring.service;

import java.util.List;

import com.spring.domain.PersonDTO;

public interface PersonService {
	boolean inserPerson(PersonDTO insert);
	boolean updatePerson(PersonDTO update);
	boolean deletePerson(String id);
	List<PersonDTO> getRows();
	PersonDTO getRow(String id);
	
}
