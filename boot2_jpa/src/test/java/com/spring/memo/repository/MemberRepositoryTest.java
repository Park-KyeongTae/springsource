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
	public void creatMember() {
		
		Member member = Member.builder()
						.id(1L)
						.name("홍길동")
						.email("hong123@naver.com")
						.password("1234")
						.address("경기도 양평")
						.build();
		
		repository.save(member);
		System.out.println(member);
	}
}
