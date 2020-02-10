package chapter04;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass my1 = MyClass.getInstance();
		MyClass my2 = MyClass.getInstance();
		MyClass my3 = MyClass.getInstance();
		
		System.out.println(my1==my2);
		System.out.println(my2==my3);
	}

}
