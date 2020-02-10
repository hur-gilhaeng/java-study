package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		/* 코드 작성합니다. */
		Random rend = new Random();
		Scanner scanner = new Scanner(System.in);

		while(true) {
			int answer = rend.nextInt(100) + 1;
			int count = 1;
			System.out.println("수를 결정하였습니다");

			int min=1,max=100;

			while(true) {
				System.out.println(min+"-"+max);
				System.out.print(count+">>");
				int inputNum = scanner.nextInt();
				if(inputNum>answer) {
					if (inputNum>max) {
						System.out.println("삽입한 값이 최대값보다 높습니다!");
					}
					else {
						max = inputNum-1;
						System.out.println("더 낮게");
					}
				}
				else if(inputNum<answer) {
					if (inputNum<min) {
						System.out.println("삽입한 값이 최소값보다 낮습니다!");
					}
					else {
						min = inputNum+1;
						System.out.println("더 높게");
					}
				}
				else break;
				count++;
			}
			System.out.println("맞았습니다");
			System.out.print("다시하시겠습니까(y/n)");

			String inputLine = scanner.next();

			if(inputLine.equals("n")) break;
		}
		scanner.close();
	}
}
