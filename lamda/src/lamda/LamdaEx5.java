package lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 	java.util.function 에서 제공하는 함수형 인터페이스
 	1) Supplier<T> get() : 리턴값은 있고, 매개변수 없음
 	2) Consumer<T> void accept(T t) : 값을 받아서 사용하는 형태
 	3) Predicate<T> boolean test(T t) : 값을 받아서 조건식에 대한 결과 반환
 	4) Function<T, R> Rapply(T t): 값을 받아서 결과를 반환
 	
 	매개변수가 2개인 함수형 인터페이스
 	BiComsumer<T U>, BiPredicate<T, U>...
 */

public class LamdaEx5 {

	public static void main(String[] args) {


		Supplier<Integer> s =()-> (int)(Math.random() * 100)+1;
		System.out.println(s.get());
		
		Consumer<Integer> c = i->System.out.println(i+"");
		c.accept(300);
		
		Predicate<Integer> p =i-> i>10;
		System.out.println(p.test(50));
		
		// T : 매개변수 타입, R: 리턴 타입
		Function<Integer, Integer> f = i -> i/10*10;
		System.out.println(f.apply(561));
	}

}
