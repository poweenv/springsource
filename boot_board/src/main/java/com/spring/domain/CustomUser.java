package com.spring.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;


@Getter
public class CustomUser extends User {

	@Autowired
	private MemberDTO memberDTO;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		
	}

	public CustomUser(MemberDTO dto) {
		super(dto.getUserid(), dto.getUserpw(), 
				dto.getAuthorites().stream().
				map(auth ->new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		this.memberDTO = dto;
	}

}
