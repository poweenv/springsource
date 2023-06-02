package stream;

import java.util.Arrays;
import java.util.List;

/*		
 * 
 * 
 
 
 
 
 	  */


public class StreamEx3 {

	public static void main(String[] args) {

		//skip(), limit() : 스트림 자르기
		
		List<String> list = Arrays.asList("apple","banana","strawberry","berry","melon","gae");
		
		// 앞의 두개의 요소는 건너뛰기, 출력은 3개만
		list.stream().skip(2).limit(3).forEach(System.out::println);
		
		
		
		
	}

}

















