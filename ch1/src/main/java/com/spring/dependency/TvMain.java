package com.spring.dependency;

public class TvMain {

		public static void main(String[] args) {
		
			/* 생성자를 사용한 멤버 변수  초기화 
			 * SonySpeaker speaker = new SonySpeaker();
			 * 
			 * TV tv = new SamsungTV();
			 */
		//	TV tv = new SamsungTV(new SonySpeaker());
			
			// setter 를 사용한 멤버 변수 초기화
			SamsungTV tv = new SamsungTV();
			
			tv.setSpeaker(new SonySpeaker());
			
			tv.powerOn();
			tv.volumUp();
			tv.volumDown();
			tv.powerOff();
			
			TvMain obj = new TvMain();
			obj.test();
			
			
			
	}
		public void test() {

		}

}
