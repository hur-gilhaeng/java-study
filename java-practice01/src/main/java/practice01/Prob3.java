package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) { // 무한루프
			
			/* 코드 작성합니다.*/
			System.out.print( "숫자를 입력하세요 : " );
			int number = scanner.nextInt();
			int result = 0;
			for (int i=number;i>=0;i-=2) {
				result += i;
			}
			System.out.println("결과 값 : "+result);
			
			if(number < 0) break; // 입력값이 0보다 작으면 반복문 종료(임으로 삽입한 라인)\
			
		}
		System.out.println("반복종료");
		scanner.close();
	}
}
