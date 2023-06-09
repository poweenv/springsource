package com.spring.dependency;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") // samsungTV 객체 생성되는 코드
public class SamsungTV implements TV{
	
	// @Inject(java) == @Autowired(springframework)
	
	
	@Inject
	//@Autowired // 주입(스프링 컨테이너가 관리하는 빈 중에서 하나가 주입됨
	@Qualifier("apple")
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
		System.out.println("samsung powerOn");
		// TODO Auto-generated method stub
		
	}


	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
//		System.out.println("samsung powerOff");
		
	}


	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
//		System.out.println("samsung volumUp");
	}


	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		System.out.println("samsung volumDown");
	}
}
