package com.spring.memo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Cart;
import com.spring.memo.entity.Member;

@SpringBootTest
public class CartRepositoryTest {

	@Autowired
	private CartRepository repository;
	
	@Autowired
	private MemberRepository memberRepository;
	
//	@Test
//	public void createCart() {
//		
//		Optional<Member> member =memberRepository.findById(1L);
//		
//		member.ifPresent(mem ->{
//			Cart cart= Cart.builder().member(mem).build();
//			
//			repository.save(cart);
//		});
//	}
	
	@Test
	public void getCart() {
		
		Optional<Cart> cart=repository.findById(5L);
		cart.ifPresent(c->System.out.println(c));
	}
	
}
























