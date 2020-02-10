package helloworld;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		Book book1 = new Book();
		
		Book book2 = book1;
		
		book1 = null;
		
		//book2 = null;
		
		System.out.println(book1);
		
		System.out.println(book2);
	}
}
