package com.spring.memo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Member;
import com.spring.memo.entity.OrderItem;
import com.spring.memo.entity.OrderStatus;
import com.spring.memo.entity.Orders;

@SpringBootTest
public class OrderRepositoryTest {

	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Test
	public void createOrders(){
		
		Member member = memberRepository.findById(1L).orElseThrow();
		
//		List<OrderItem> orderItem = orderItemRepository.findAllById(null);
				
		Orders orders= Orders.builder()
							 .member(member)
							 .orderDate(LocalDateTime.now())
							 .orderStatus(OrderStatus.ORDER)
							 .build();
		
		Orders newOrder = repository.save(orders);
		System.out.println(newOrder);
	}
}
