package com.spring.dependency;

public class LgTv implements TV{
	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 on");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV - 전원 off");
		
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
