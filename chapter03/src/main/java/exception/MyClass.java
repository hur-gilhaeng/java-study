package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some code1");
		System.out.println("some code2");
		int a = 8;
		if(10-2==a) {
			throw new MyException();
		}

		if(10-2==a) {
			throw new IOException();
		}

		System.out.println("some code3");
		System.out.println("some code4");
	}
}
