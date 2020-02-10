package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		int result = 0;
		System.out.println("some codes0");
		try {
			System.out.println("some codes1");
			result = (1+2+3) / b;
			System.out.println("some codes2");
		} catch(ArithmeticException ex) {
			System.out.println("some codes3");
			System.out.println("예외처리:"+ex);
			
			// 오류 발생시 해야할 3가지
			//   1. 사용자에게 양해 구하기 (사과)
			System.out.println("서비스의 상태가 원활하지 않습니다. \n 양해 바랍니다...");
			
			//   2. 오류 기록하기 (로그) - 파일,DB 등에 남긴다.
			System.out.println(ex);
			
			//   3. 절차에 맞게 종료하기 (정상종료)
			return;
			
		} finally {
			System.out.println("some codes4");
		}
		System.out.println("some codes5");
		System.out.println("result: "+result);

	}

}
