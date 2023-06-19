package com.spring.memo.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.Member;
import com.spring.memo.entity.OrderItem;
import com.spring.memo.entity.OrderStatus;
import com.spring.memo.entity.Orders;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ItemRepository itemRepository;
//	@Test
//	public void createOrders() {
//	Member member= memberRepository.findById(1L).orElseThrow(); 
//
//		
//	Orders orders = Orders.builder()
//						  .member(member)
//					      .orderDate(LocalDateTime.now())
//					      .orderStatus(OrderStatus.ORDER)
//					      .build();
//	
//	
//	Orders newOrder=orderRepository.save(orders);
//	System.out.println(newOrder);
//	}
	@Test
	public void createOrderItem() {
		
		Item item = itemRepository.findById(1L).orElseThrow();
		Orders orders = ordersRepository.findById(1L).orElseThrow();
	
		OrderItem orderItem = OrderItem.builder()
									   .item(item)
									   .orders(orders)
									   .orderPrice(1000)
									   .count(1)
									   .regTime(LocalDateTime.now())
									   .updateTime(LocalDateTime.now())
									   .build();
		 
		OrderItem newOrder = orderItemRepository.save(orderItem);
		System.out.println(newOrder);
		
	}
}
