package com.spring.dependency;

public class SamsungTV implements TV {
	
	private Speaker speaker; // has-a(포함) 관계
		
	// 매개변수를 받지 않는 생성자 : default 생성자	
	
	// 기본 생성자
	public SamsungTV() {
		System.out.println("SamsungTV 인스턴스 생성 - default 생성자");
	}
	// 생성자
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker; // 멤버 변수 초기화
		System.out.println("SamsungTV 인스턴스 생성 - 인자 생성자");
	}

	// setter 메소드
	public void setSpeaker(Speaker speaker) {
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
