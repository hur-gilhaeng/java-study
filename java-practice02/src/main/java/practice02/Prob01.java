package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액: ");

		/* 코드 작성합니다.*/
		int cash = scanner.nextInt();
		
		for(int i=0;i<MONEYS.length;i++) {
			int count = 0;
			while(MONEYS[i]<=cash){
				cash-=MONEYS[i];
				count++;
			}
			System.out.println(MONEYS[i]+" : "+count+"개");
		}
		
		scanner.close();
	}

}
