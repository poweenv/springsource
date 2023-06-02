package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx1 {

	public static void main(String[] args) {
	
		
		
		List<String> list = Arrays.asList("dog","cat","pig","slaim","lion","rabit");
		
		List<String> list1 = new ArrayList<String>();
		for (String str : list) {
			if(str.startsWith("d")) {
				list1.add(str);
			}
		}
		for (String str : list1) {
			System.out.println(str);
		}
		// filter() : 스트림 요소 걸러내기
		list.stream().filter(str ->str.startsWith("d")).forEach(System.out::println);

		
	}

}

















