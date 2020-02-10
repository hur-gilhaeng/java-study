package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		// 문자열을 int형으로
		int i = Integer.parseInt(s);
		// cf 반대로. (int형을 문자열로)
		String s2 = String.valueOf(i);
		
		System.out.println(s+" : "+s2);
		
		// 유니코드에서 '지정된' 정수 값을 출력. ex) 'A'=10, 'Ⅳ'=4
		// 만약 지정된 값이 없다면 -1을 출력.
		int a0 = Character.getNumericValue('A');
		int a1 = Character.getNumericValue('Ⅳ');
		int a2 = Character.getNumericValue('四'); // 지정안됨 -1;
		int a3 = Character.getNumericValue('삼'); // 지정안됨 -1;
		
		System.out.println(a0);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		
		// 2진수
		String s3 = Integer.toBinaryString(15);
		System.out.println(s3);
		
		
		// 16진수
		String s4 = Integer.toHexString(255);
		System.out.println(s4);
		
	}

}
