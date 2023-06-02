package lamda;

/*  람다식(자바 8 부터 추가)
 	- 함수형 언어
 	- 메서드를 하나의 식으로 표현
 	- 익명 클래스 객체
 	
 	- 함수형 인터페이스 다양하게 제공(java.util.Function 패키지)
 */


public class Lamda1 {
	int max(int a, int b) {
		return a > b ? a : b;
	}
	
	//(int a, int b)->{return a > b ? a : b};
	
	//(int a, int b)-> a > b ? a : b;
	
	//(a, b)-> a > b ? a : b;
	
	void printVar(String name, int i) {
		System.out.println(name + "=" +i);
	}
	//(String name, int i)->{System.out.println(name + "=" +i)};
	//(String name, int i)->System.out.println(name + "=" +i);
	//(name, i)->System.out.println(name + "=" +i);
	
	int squqre(int x) {
		return x * x;
	}
	//(int x) -> {return x * x};
	//(x) -> x * x
	
	int roll() {
		return (int)(Math.random()*6);
	}
//	() ->{return (int)(Math.random()*6)}
//	() ->(int)(Math.random()*6)
	
	
}











