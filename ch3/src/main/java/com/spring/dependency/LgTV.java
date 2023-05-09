package com.spring.dependency;

public class LgTV implements TV{
@Override
public void PowerOn() {
	
	System.out.println("LGTV - 전원 ON");
}
@Override
public void PowerOff() {
	
	System.out.println("LGTV - 전원 Off");
}
@Override
public void volumUp() {
	
	System.out.println("LGTV - 볼륨 Up");
}
@Override
public void volumDown() {
	
	System.out.println("LGTV - 볼륨 Down");
}
}
