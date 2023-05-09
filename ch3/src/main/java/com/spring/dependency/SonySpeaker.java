package com.spring.dependency;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

	
	
	public SonySpeaker() {
		System.out.println("SonySpeaker 인스턴스 생성");
	}
	@Override
	public void volumUp() {
		System.out.println("SonySpeaker Volum Up");

	}

	@Override
	public void volumDown() {
		System.out.println("SonySpeaker Volum Down");

	}

}
