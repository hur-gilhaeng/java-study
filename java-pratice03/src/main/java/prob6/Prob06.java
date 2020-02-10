package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {

			/*  코드를 완성 합니다 */
			System.out.print(">> ");
			String expr = scanner.nextLine();

			if("quit".equals(expr)) {
				System.out.println(">> 종료.");
				break;
			}

			String[] tokens = expr.split(" ");

			if(tokens.length != 3) {
				System.out.println(">> 계산할수 없는 연산식 입니다.");
				continue;
			}
			
			if(!(isNum(tokens[0])&&isNum(tokens[2]))) {
				System.out.println(">> 피연산자는 \'수\'이어야 합니다.");
				continue;
			}

			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);

			Calculate cal;

			if("+".equals(tokens[1])) {
				cal = new Add();
			}
			else if("-".equals(tokens[1])) {
				cal = new Sub();
			}
			else if("*".equals(tokens[1])) {
				cal = new Mul();
			}
			else if("/".equals(tokens[1])) {
				if(rValue == 0) {
					System.out.println(">> 0으로 나눌수 없습니다!!");
					continue;
				}
				cal = new Div();
			}
			else {
				System.out.println(">> 잘못된 연산자 입니다.");
				continue;
			}
			cal.setValue(lValue, rValue);
			System.out.println(">> "+cal.calculate());

		}

		scanner.close();
	}
	private static boolean isNum(String s) {
		boolean result = s.replaceAll("[+-]?\\d+", "").equals("");
		return result;
	}

}
