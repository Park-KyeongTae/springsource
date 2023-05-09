package com.spring.dependency;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker; // has-a(포함) 관계
		
	// 매개변수를 받지 않는 생성자 : default 생성자	
	// 기본 생성자
	public SamsungTV() {
		
	}
	// 생성자
	public SamsungTV(SonySpeaker speaker) {
		super();
		this.speaker = speaker; // 멤버 변수 초기화
	}

	// setter 메소드
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}
	

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
		 //System.out.println("SamsungTV - 볼륨 Up");
		 speaker.volumUp();
	 }
	 @Override
	public void volumDown() {
		 //System.out.println("SamsungTV - 볼륨 Down");
		 speaker.volumDown();
	 }
}
