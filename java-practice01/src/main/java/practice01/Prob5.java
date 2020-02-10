package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for( int i = 1; i <=100; i++ ) {

			/* 코드 작성합니다.*/
			String str = String.valueOf(i);
			int count = 0;

			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='3'||str.charAt(j)=='6'||str.charAt(j)=='9')
					count++;
			}

			if(count>0) {
				System.out.print(i+" ");
				for(int n=0;n<count;n++) {
					System.out.print("짝");
				}
				System.out.println();
			}

		}
	}
}
