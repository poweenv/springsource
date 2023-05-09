package com.spring.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

		public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");	
			
	//		TV tv = (TV) ctx.getBean("samsungTV"); @Component 로 생성 시 id 는 클래스명 사용(앞자리는 소문자)
			TV tv = (TV) ctx.getBean("tv"); 	 //@Component("tv")로 생성시 id는 클래스명이 아닌 tv로 설정가능
		
			tv.powerOn();
			tv.volumUp();
			tv.volumDown();
			tv.powerOff();

			
	}


}
