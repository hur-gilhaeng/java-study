package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new MyClass().danger();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
