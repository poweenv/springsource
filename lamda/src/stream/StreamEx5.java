package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

// 최종 연산
// count(), max(), min(), average(), findFirst(), sum()


public class StreamEx5 {

	public static void main(String[] args) {
	
		
		//int => Stream
		IntStream stream1 = Arrays.stream(new int [] {1,2,3,4,56,7,8,94,73,82,14});
		IntStream stream2 = Arrays.stream(new int [] {1,2,3,4,56,7,8,94,73,82,14});
		IntStream stream3 = Arrays.stream(new int [] {1,2,3,4,56,7,8,94,73,82,14});
		IntStream stream4 = Arrays.stream(new int [] {1,2,3,4,56,7,8,94,73,82,14});
		//2의 배슈는 몇개인가
		//stream1.filter(i -> i%2==0);
		System.out.println("2의 배수 개수 : "+stream1.filter(i -> i % 2 ==0).count() );
		System.out.println("hap : "+stream2.filter(i -> i % 2 ==0).sum() );
		System.out.println("2의 배수 평균 : "+stream3.filter(i -> i % 2 ==0).average() );
		System.out.println("2의 배수 평균 : "+stream4.filter(i -> i % 2 ==0).min() );
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

















