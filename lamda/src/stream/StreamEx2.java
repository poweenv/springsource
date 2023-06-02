package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*		스트림 연산
 * 		- 다양한 연산을 이용해 복잡한 작업들을 간단히 처리함
		- 연산 종료
			1) 중간 연산 : 연산 결과가 스트림
			- map(),filter(),skip().....
			2) 최종 연산 : 연산 결과가 스트림이 아닌 상태 
			- forEach(), collect(),reduce(),count(),max(),min()...

 	  */


public class StreamEx2 {

	public static void main(String[] args) {
		// 파일 객체에서 이름을 출력
		
		List<File> list = new ArrayList<File>();
		
		list.add(new File("c:\\file.txt"));
		list.add(new File("c:\\file2.txt"));
		list.add(new File("c:\\file3.txt"));
		list.add(new File("c:\\file4.txt"));
		list.add(new File("c:\\file6.txt"));
		
		// 이름만 수집한 후 출력
		
		List<String> fileNames = new ArrayList<String>();
		
		for (File file : list) {
			fileNames.add(file.getName());
		}
		
		for (String string : fileNames) {
			System.out.println(string);
		}
		
		
		// stream 으로 처리?
		// stream 변환(list.stream()) -> 연산(map()) -> 결과 출력
		// map(): 스트림의 요소에 저장된 값 중에서 원하는 필드만 추출하거나 특정 형태로 변환시 사용
		Stream<String> names= list.stream().map(File::getName);
		names.forEach(f -> System.out.println(f));
		
		list.stream().map(File::getName).forEach(f->System.out.println(f));
		
		List<String> fruits = Arrays.asList("melon","grape","apple","banana","mango");
//		fruits 대문장로 변경한 걸 리스트로 생성 후 출력
		
		List<String> upper = new ArrayList<String>();
		for (String string : fruits) {
			upper.add(string.toUpperCase());
		}
		for (String string : upper) {
			System.out.println(string);
		}
		
		System.out.println();
		
		
		fruits.stream().map(s ->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		fruits.stream().map(String::toUpperCase).forEach(System.out::println);
		
		
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("hong",99));
		stuList.add(new Student("song",39));
		stuList.add(new Student("sejong",29));
		stuList.add(new Student("slong",69));
		stuList.add(new Student("salong",62));
		stuList.add(new Student("sulong",2));
		
		// 이름의 시작이 김스올 시작하는 학생들의 이름을 출력
		for (Student student : stuList) {
			if(student.getName().startsWith("s")){
				System.out.println(student.getName());
			}
		}
		stuList.stream().filter(stu -> stu.getName().startsWith("s"))
					//	.forEach(s-> System.out.println(s.getName()));
						.forEach(System.out::println);
		
		
		List<String> fruits2 = Arrays.asList("melon","grape","apple","banana","mango");
	
		Stream<File> stream = Stream.of(new File("d:\\test1.txt"),new File("d:\\test2.txt"),
					new File("d:\\test1.java"),new File("d:\\test2.bak")
					,new File("d:\\test2"),new File("d:\\test2.ask"));
		
		// 파일 확장자 추출한 후 중복을 제거하고 출력하기
		// 파일명 추출 -> 확장자 추출 -> 확장자만 모음 -> 중복제거 -> 출력
		stream.map(File::getName)
		.filter(f->f.indexOf(".") > -1)
		.peek(f->System.out.println("filter 통과 후 "+f))
		.map(f -> f.substring(f.lastIndexOf(".")+1))
		.distinct()
		.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
	}

}

















