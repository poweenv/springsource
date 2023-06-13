package com.spring.memo.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.Orders;
import com.spring.memo.entity.OrderItem;

@SpringBootTest
public class OrderItemRepositoryTest {

	@Autowired
	private OrderItemRepository repository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void OrderItem() {
		
		Item item = itemRepository.findById(1L).orElseThrow();
		
		Orders order = orderRepository.findById(1L).orElseThrow();
		
		OrderItem orderItem = OrderItem.builder()
									   .item(item)
									   .orders(order)
									   .orderPrice(122222)
									   .count(2)
									   .regTime(LocalDateTime.now())
									   .updateTime(LocalDateTime.now())
									   .build();
		
		OrderItem newOrderItem = repository.save(orderItem);
		System.out.println(newOrderItem);
		
	}
}
