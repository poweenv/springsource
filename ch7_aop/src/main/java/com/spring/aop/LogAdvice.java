package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 횡단관심사를 처리해 줄 클래스
// 횡단관심사를 언제 처리할 것인가?
// Before(메소드 호출 전에), After returning(메소드 호출 이후에), After throwing(메소드 예외 발생 후)
// After(메소드 호출 후 예외 발생 여부와 관계없이), Around(메소드 호출 이전과 이후 모두 적용)-가장 대중적
// 개발이 끝나고 확인용으로 로그를 남겨야 할때 일일이 들어가서 메소드를 호출하지 않고 로그를 처리할 객체를 만들어서 지정을 해준다
// 그 뒤 스프링프레임워크에 맡기면 설정해둔 것에 따라 알아서 실행 해준다
@Component("log")
@Aspect
public class LogAdvice {
	
	// 표현식 작성시
	// execution(언제 실행될 것인지 넣어준다) : 표현식- 특정 메소드만 advice를 함
	//* : 리턴타입
	// com.spring.aop : 패키지명
	// Product : 클래스명
	// getInfo() : 메소드명
//	@Before(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
//	}
	
	
//	@After(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void AfterLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출됨(예외 발생 여부와 관계없이 무조건 실행됨)");
//	}
	
//	@AfterThrowing(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterThrowingLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 예외 발생시 호출 됨 )");
//	}
	@AfterReturning(value = "execution(* com.spring.aop.Product.getInfo())")
	public void afterReturningLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행 후 예외발생 없을 때만 호출 됨 )");
	}
	@Around(value = "execution(* com.spring.aop.Product.getInfo())")
	public void AroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통로그] 비즈니스 로직 수행 전 )");
		try {
			pjp.proceed(); //처리해야 하는 메소드 호출됨
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출 됨");
	}
}
