package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.print( "두 정수와 연산자를 입력하시오 >> " );
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operation = scanner.next();
		
		scanner.close();
		
		/* operation에 따라 4칙 연산 객체를 생성하고 caculate 메서드를 호출합니다. */
		
		Arithmetic arith = null;
		if("+".equals(operation)) {
			arith = new Add();
		}
		else if("-".equals(operation)) {
			arith = new Sub();
		}
		else if("*".equals(operation)) {
			arith = new Mul();
		}
		else if("/".equals(operation)) {
			if(b == 0) {
				System.out.println(">> 0으로 나눌수 없습니다!!");
			}
			else {
				arith = new Div();
			}
		}
		else {
			System.out.println(">> 잘못된 연산자 입니다.");
		}

		if(arith == null)
			System.out.println(">> 식이 잘못 되었습니다.");
		else
			System.out.println(arith.calculate(a, b));
		
	}
}
