package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		/*
		 * LgTv lgTv = new LgTv(); lgTv.turnOn(); lgTv.soundUp(); lgTv.soundDown();
		 * lgTv.turnOff();
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		TV tv = (TV) ctx.getBean("");
		
//		TV samsungTV = new SamsungTV();
		TV samsungTV = (TV) ctx.getBean("samsung");
		samsungTV.powerOn();
		samsungTV.volumUp();
		samsungTV.volumDown();
		samsungTV.powerOff();

}
}