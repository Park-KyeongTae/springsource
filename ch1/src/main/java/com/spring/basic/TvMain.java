package com.spring.basic;

public class TvMain {

	public static void main(String[] args) {
//		LgTV lgTV = new LgTV();
//		lgTV.turnOn();
//		lgTV.SoundUp();
//		lgTV.SoundDown();
//		lgTV.turnOff();

		TV samsungTV = new SamsungTV();
		samsungTV.PowerOn();
		samsungTV.volumUp();
		samsungTV.volumDown();
		samsungTV.PowerOff();
	}

}
