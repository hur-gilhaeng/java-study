package chapter04;

public class WrapperClassTest {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('A');
		Boolean b = new Boolean(true);
		
		System.out.println(i);
		System.out.println(c);
		System.out.println(b);
		
		// Auto Boxing
		// Integer j1 = new Integer(10);과 같음
		Integer j1 = 10;
		// 주의! 아래코드는 String과 같이 
		// 위에서 만들어진 j1의 레퍼런스를 가리키게됨.
		Integer j2 = 10;
		System.out.println(j1+":"+j2);
		System.out.println(j1 == j2);
		System.out.println(i == j1);
		
		// Auto Unboxing
		// int j3 = 20 + i.intValue();
		 int j3 = 20 + i;
		
		System.out.println(j3);
		
	}

}
