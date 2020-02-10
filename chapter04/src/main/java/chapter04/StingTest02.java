package chapter04;

public class StingTest02 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		
		String s4 = s2.concat("??");
		
		String s5 = "!".concat(s2).concat("@");
		

		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		// equals 메서드 주의할 점
		System.out.println(equalHello("hello"));
		System.out.println(equalHello(null));
	}

	private static boolean equalHello(String string) {
		// 오류 : string인자가 null이 들어오면 오류발생!
		//return string.equals("hello");
		return "hello".equals(string);
	}

}
