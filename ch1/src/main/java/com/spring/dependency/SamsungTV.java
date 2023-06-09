package com.spring.dependency;

public class SamsungTV implements TV{
	
	
	private SonySpeaker speaker; //has-a(관계)포함
	
	// 매개변수를 받지 않는 생성자 : default 생성자
	public SamsungTV() {}
	
	
	public SamsungTV(SonySpeaker speaker) {
		super();
		this.speaker = speaker; // 멤버 변수 초기화
	}


	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 파워 on");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 파워 off");
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
