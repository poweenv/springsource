package com.spring.memo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;
	
	@Test
	public void createMember() {
	
		Member member= new Member();
		
		member= Member.builder().name("long")
								.password("long123")
								.address("구로1길310")
								.email("long123@naver.com")
								.build();
		
		repository.save(member);
	}
}
