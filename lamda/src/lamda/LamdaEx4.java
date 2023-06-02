package lamda;

public class LamdaEx4 {

	public static void main(String[] args) {

//		Lamda4 lamda = (x, y) -> x > y ? x : y;
//		System.out.println(lamda.max(150, 100));

		Lamda5 lamda = (x, y) -> x < y ? x : y;
		System.out.println(lamda.min(150, 100));
		
		

	}

}
