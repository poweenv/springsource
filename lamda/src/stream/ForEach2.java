package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/*


 	  */


public class ForEach2 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A","B","C","d","2");
		
		list.forEach(item -> System.out.println(item));
		list.forEach(System.out::println);
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("hong",99));
		stuList.add(new Student("song",39));
		stuList.add(new Student("jong",29));
		stuList.add(new Student("tong",69));
		
		stuList.forEach(student -> System.out.println(student.getName()+" : "+student.getJumsu()));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 90); 
		map.put("B", 85); 
		map.put("C", 80); 
		map.put("D", 70); 
		map.put("E", 60); 
		map.put("F", 50); 
		
		// Map 데이터 처리(기존방식)
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Item : " +entry.getKey()+", Count : "+entry.getValue());
		}
		
		System.out.println();
		
		map.forEach((k,v) -> System.out.println("Item : " +k+", Count : "+v));


		//key 값이 E 일때  hello, E 출력문을 추가
		map.forEach((k,v) -> {System.out.println("Item : " +k+", Count : "+v);
			if("E".equals(k)) {
				System.out.println("Hello,E");
			}
			
		});
	}

}

















