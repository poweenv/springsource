package com.spring.dependency;

public class SamsungTV implements TV{
	
	
	private Speaker speaker; //has-a(관계)포함
	
	// 매개변수를 받지 않는 생성자 : default 생성자
	public SamsungTV() {
		System.out.println("SamsungTV 인스턴스 생성 - default 생성자");
	}
	
	
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("SamsungTV 인스턴스 생성 - 인자 생성자");
		this.speaker = speaker; // 멤버 변수 초기화
	}


	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}


	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		
	}
}
