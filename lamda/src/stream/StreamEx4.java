package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 최종 연산
// collect()


public class StreamEx4 {

	public static void main(String[] args) {
		
		
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("hong",99));
		stuList.add(new Student("song",39));
		stuList.add(new Student("sejong",29));
		stuList.add(new Student("slong",69));
		stuList.add(new Student("salong",62));
		stuList.add(new Student("sulong",2));
		
		// 새로운 리스트에 학생들의 점수를 저장하고 출력
		List<Integer> jumsuList = stuList.stream().map(s -> s.getJumsu()).collect(Collectors.toList());
		System.out.println(jumsuList);
		
		
		
		// 샐오운 뤼스트
		List<String> fruits = Arrays.asList("melon","grape","apple","banana","mango");

		List<String> uppers = fruits.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(fruits);
		System.out.println("-----------");
		System.out.println(uppers);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

















