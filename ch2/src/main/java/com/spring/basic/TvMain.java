package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
//		LgTV lgTV = new LgTV();
//		lgTV.turnOn();
//		lgTV.SoundUp();
//		lgTV.SoundDown();
//		lgTV.turnOff();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml"); // 인스턴스 생성하고 관리하는 곳
		
		TV samsungTV = (TV)ctx.getBean("samsung"); //config.xml 안에있는 samsung객체 가져와
		samsungTV.PowerOn();
		samsungTV.volumUp();
		samsungTV.volumDown();
		samsungTV.PowerOff();
		
		TV samsungTV2 = (TV)ctx.getBean("samsung"); //config.xml 안에있는 samsung객체 가져와
		
		System.out.println(samsungTV == samsungTV2 ? "같음" : "다름");
	}

}
