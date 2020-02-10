package chapter04;
/*
 * 싱글톤 예제
 * 
 */
public class MyClass {
	private static MyClass instance = null;

	private MyClass() {}

	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}
