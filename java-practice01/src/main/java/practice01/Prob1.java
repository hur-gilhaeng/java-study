package practice01;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "수를 입력하세요 : " );
		int number = scanner.nextInt();
		
		/* 코드 작성합니다. */
		
		int i,j;
		i = number%3;
		j = number/3;
		
		if( i==0 && j>=1 )
			System.out.println("3의 배수 입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");
		
		scanner.close();
	}
}
