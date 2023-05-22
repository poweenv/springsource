package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("rec")
public class RecCalc implements Calculator {

	@Override
	public long factorial(long num) {
		// 재귀호출로 factorial 구하기
		
		int result =1;
		if(num == 0) {
			return 1;
		}else {
			return num * factorial(num-1);
		}
	}

}
