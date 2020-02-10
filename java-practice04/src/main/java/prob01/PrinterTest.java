package prob01;

import java.util.Stack;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );

		System.out.println(printer.sum(1,2,3,4,5,6,7,8,9));
		System.out.println("====");
		
		printer.println( 1, 2, 3, 4, 5, "Hello", new StringBuffer("20") );
		System.out.println("====");
		
		// 순회가능한 Colletion
		Iterable<Integer> tmep = new Stack<>();
		((Stack<Integer>) tmep).push(1);
		((Stack<Integer>) tmep).push(2);
		((Stack<Integer>) tmep).push(3);
		((Stack<Integer>) tmep).push(4);
		// 가변변수과 '순회가능한 묶음'(Iterable)은 다르다!
		System.out.println(printer.sum(tmep));
		// 스택 tmep를 한덩어리(객체)로 본다
		printer.println(tmep);
	}

}
