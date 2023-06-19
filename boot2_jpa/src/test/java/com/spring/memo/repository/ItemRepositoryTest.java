package com.spring.memo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.ItemSellStatus;

@SpringBootTest
public class ItemRepositoryTest {

	// ItemRepositoryTest 잘 작성되었는지 테스트 : 단위 테스트

	@Autowired
	private ItemRepository repository;

	@Test
	public void itemCreateTest() {
		Item item = new Item();
		item.setItemNm("993 모델");
		item.setPrice(300000);
		item.setStockNumber(40);
		item.setItemDetail("뉴발란스 신발");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
//
//		Item item = Item.builder()
//					    .itemNm("반팔티")
//					    .price(10000)
//					    .stockNumber(100)
//					    .itemDetail("카라티")
//					    .itemSellStatus(ItemSellStatus.SELL)
//					    .regTime(LocalDateTime.now())
//					    .updateTime(LocalDateTime.now())
//					    .build(); 
//		
		Item newItem = repository.save(item);
		System.out.println(newItem);
	}

	// 조회
//	@Test
//	public void getItem() {

//		Optional<Item> item = repository.findById(1L);
//		item.ifPresent(ele -> System.out.println(ele));
//
//		repository.findById(1L).ifPresent(ele -> System.out.println(ele));
//
//		Item item = repository.findById(5L).orElseThrow(EntityNotFoundException::new);
//
//		System.out.println(item);
//	}

	// 전체조회
//	@Test
//	public void getItems() {
//
//		List<Item> list = repository.findAll();
//
//			for (Item item : list) {
//				System.out.println(item);
//			}
//
//		list.forEach(item -> System.out.println(item));
//	}

	// 상품명 조회
//	@Test
//	public void getItems() {

//		List<Item> list = repository.findByItemNm("반팔티");
//		list.forEach(item -> System.out.println(item));
		
//		repository.findByItemNm("반팔티")
//		          .forEach(item -> System.out.println(item));
//	}
	
	// 상품명 or 상품 상세 조회
//	@Test
//	public void getNameOrDetail() {
//		
//		List<Item> list = repository.findByItemNmOrItemDetail("블루투스 스피커", "카라티");
//		
//		list.forEach(item -> System.out.println(item));
//	}
	
//	 특정가격 이하 상품 조회
//		@Test
//		public void getPriceLessThan() {
//			
//			List<Item> list = repository.findByPriceLessThan(50000);
//			list.forEach(item -> System.out.println(item));
//		}
		
//		 특정가격 이하 상품 조회 및 정렬
			@Test
			public void getPriceLessThanOrder() {
				
				List<Item> list = repository.findByPriceLessThanOrderByPriceDesc(400000);
				list.forEach(item -> System.out.println(item));
			}
}
