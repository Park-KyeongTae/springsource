package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Spring framework 
// 인스턴스를 생성하고 관리를 해줌 => 모든 인스턴스를 생성하고 관리하는 것은 아니고 지정한 인스턴스만 처리
//                                    인스턴스 생성 시 singleton 방식
public class HelloApp {

	public static void main(String[] args) {
		
		System.out.println("=== 컨테이너 구동 전 ====");
		
		// src/main/resources ==> ClassPath 라고 부름
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml"); //  인스턴스를 생성하고 관리를 지정하는 곳
		
		System.out.println("=== 컨테이너 구동 전 ====");
		MessageBeen msg = (MessageBeen)ctx.getBean("msg"); // 아이디로 찾아오기
		msg.sayHello("홍길동");
		
		
		
		
		
		
	}

}
