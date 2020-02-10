package helloworld;

public class Book {
	int a;
	int b;
	
	public Book() {
		this.a = 0;
		this.b = 0;
	}	
	public Book(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		String tmp = a+" "+b;
		
		return tmp;
	}
}
