package prob01;
import java.util.Scanner;


public class Gugudan {

	static int resultNumber = 0;

	public static void main( String[] args ) {
		int l = randomize( 1, 9 );
		int r = randomize( 1, 9 );

		resultNumber = l * r;

		int[] answerNumbers = randomizeAnswers();
		
		/*정답배열에 중복을 막기 위해서 임의로 추가한 부분 AFF_00*/
		boolean ck = true;
		for(int i=0;i<answerNumbers.length;i++) {
			if(answerNumbers[i] == resultNumber) {
				ck = false;
				break;
			}
		}
		if(ck){	
		/*부분 part AFF_00 끝*/

		int loc = randomize( 0, 8 );
		answerNumbers[ loc ] = resultNumber;

		/*임의로 추가한 부분 part AFF_01*/
		}
		/*부분 part AFF_01 끝*/
		
		System.out.println( l + " x " + r + " = ?" );

		int length = answerNumbers.length;
		for( int i = 0; i < length; i++ ) {
			if( i % 3 == 0 ) {
				System.out.print( "\n" );
			} else {
				System.out.print( "\t" );
			}

			System.out.print( answerNumbers[ i ] );
		}

		System.out.print( "\n\n" );
		System.out.print( "answer: " );

		Scanner s = new Scanner( System.in );
		
		//  이 부분에 적당한 코드를 작성합니다. //
		int inputInt = s.nextInt();

		if(resultNumber==inputInt) {
			System.out.println("정답!");
		}
		else {
			System.out.println("오답...");
		}
		s.close();

	}

	private static int randomize( int lNum, int rNum ) {
		int random = (int) ( Math.random() * rNum ) + lNum;
		return random;
	}

	private static int[] randomizeAnswers() {

		final int COUNT_ANSWER_NUMBER = 9;
		final int MAX_ANSWER_NUMBER = 81;

		int[] boardNumbers = new int[ COUNT_ANSWER_NUMBER ];
		int occupied = 0;

		while( occupied < COUNT_ANSWER_NUMBER ) {

			int random = ( int )( Math.random() * MAX_ANSWER_NUMBER ) + 1;

			boolean evaluted = false;
			for( int i = 0; i < occupied; i++ ) {
				if(  boardNumbers[i] == random /* 이 부분에 적당 조건의 코드를 입력 합니다. */ ) {
					evaluted = true;
					break;
				}
			}

			if( !evaluted ) {
				boardNumbers[ occupied++ ] = random;
			}
		}

		return boardNumbers;
	}	
}
