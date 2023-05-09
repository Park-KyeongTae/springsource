package com.spring.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {
// String str = "String"; // new 와 같은 역활

	public static void main(String[] args) {

		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		TV tv = (TV)ctx.getBean("tv");
		
		tv.PowerOn();
		tv.volumUp();
		tv.volumDown();
		tv.PowerOff();

	}

}
