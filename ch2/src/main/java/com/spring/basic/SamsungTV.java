package com.spring.basic;

public class SamsungTV implements TV {
	@Override
	public void PowerOn() {
		 System.out.println("SamsungTV - 파워 ON");
	 }
	 @Override
	public void PowerOff() {
		 System.out.println("SamsungTV - 파워 Off");
	 }
	 @Override
	public void volumUp() {
		 System.out.println("SamsungTV - 볼륨 Up");
	 }
	 @Override
	public void volumDown() {
		 System.out.println("SamsungTV - 볼륨 Down");
	 }
}
