package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.domain.CustomUser;
import com.spring.domain.SpUserDTO;
import com.spring.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

/*
 	
 	
 	UserDetails(interface)  <--------- User(class) <--------- CustomUser
 */

@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("회원정보  : "+username);
		
		SpUserDTO dto = mapper.read(username);
		
		log.info("로그인후 : " +dto);
		
		return new CustomUser(dto);
	}

}
