package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];

		System.out.println("5개의 숫자를 입력하세요.");

		/* 코드 작성합니다.*/		
		for(int i=0;i<intArray.length;i++) {
			intArray[i] = scanner.nextInt();
		}
		
		double sumNum = 0;
		for(int i=0;i<intArray.length;i++) {
			sumNum+=intArray[i];
		}
		double avrNum = sumNum/intArray.length;
		
		System.out.println("평균은 " + avrNum + " 입니다" );
		scanner.close();
	}

}
