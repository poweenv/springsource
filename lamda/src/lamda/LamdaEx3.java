package lamda;


public class LamdaEx3 {

	public static void main(String[] args) {

		Lamda3 lamda = (x) -> System.out.println(x);

		
		
		lamda = (x) ->{
			int i = 10;
			System.out.println(i*i);
		};
		lamda.method(100);
	}

}
