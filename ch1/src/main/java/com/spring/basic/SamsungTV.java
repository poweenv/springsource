package com.spring.basic;

public class SamsungTV implements TV{
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
