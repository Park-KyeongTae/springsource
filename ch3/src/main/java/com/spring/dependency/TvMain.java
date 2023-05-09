package com.spring.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {
// String str = "String"; // new 와 같은 역활

	public static void main(String[] args) {

		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
//		TV tv = (TV)ctx.getBean("samsungTV"); @Component 사용하면 ID값은 클래스명을 사용(앞자리는 소문자로 변경)
		TV tv = (TV)ctx.getBean("tv"); // @Component("tv")
		
		tv.PowerOn();
		tv.volumUp();
		tv.volumDown();
		tv.PowerOff();

	}
}
