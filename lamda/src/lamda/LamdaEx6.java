package lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaEx6 {

	public static void main(String[] args) {
		
		
		// 문자열을 리턴하는 기능 구현
		Supplier<String> s =()->("supplier");
		System.out.println(s.get());
		// 문자열을 입력받아서 문자열의 길이가 0인지 판단 기능 구현
		Predicate<Integer> p=i -> i==0;
		System.out.println(p.test(1));
		// 문자열을 입력받아서 출력하는 기능 구현
		Consumer<String> c = i->System.out.println(i+"");
		c.accept("Consumer");
		// 문자열을 입력받아서 정수로 리턴 기능 구현
		Function<String, String> f= i -> i+"func"+"tion";
		System.out.println(f.apply("Function"));
	
	}

}
