package com.spring.factorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacMain {

	// AOP : 횡단관심사 프레임워크가 처리
	
	// 주된관심사 : factorial 구하기
	// 횡단관심사 : 누가 더 빠를까? 시간이 얼마나 걸리는지
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Calculator cal = (Calculator)ctx.getBean("rec");
		System.out.println("======================");
		System.out.println("10! = "+cal.factorial(10));
		
		cal = (Calculator) ctx.getBean("forc");
		System.out.println("======================");
		System.out.println("10! =" +cal.factorial(10));

	}

}
