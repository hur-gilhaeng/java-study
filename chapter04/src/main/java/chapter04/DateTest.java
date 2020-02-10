package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		printDate1(now);
		printDate2(now);
		
	}

	public static void printDate1(Date now) {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d = sdf.format(now);
		System.out.println(d);
	}

	@SuppressWarnings("deprecation")
	private static void printDate2(Date now) {
		
		// 년도 (+1900)
		int year = now.getYear();
		
		// 월(0~11, +1)
		int month = now.getMonth();
		
		// 일
		int date = now.getDate();
		
		// 시
		int hours = now.getHours();
		
		// 분
		int minutes = now.getMinutes();
		
		// 초
		int seconds = now.getSeconds();
		
		System.out.println(
				(year+1900) + "-" + 
				(month+1) 	+ "-" + 
				date 		+ " " +
				
				hours	 	+ ":" + 
				minutes 	+ ":" + 
				seconds );
	}
}
