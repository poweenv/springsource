package com.spring.basic;

public class TvMain {

	public static void main(String[] args) {
		/*
		 * LgTv lgTv = new LgTv(); lgTv.turnOn(); lgTv.soundUp(); lgTv.soundDown();
		 * lgTv.turnOff();
		 */

		TV samsungTV = new SamsungTV();
		samsungTV.powerOn();
		samsungTV.volumUp();
		samsungTV.volumDown();
		samsungTV.powerOff();
	}

}
