package prob03;

public class MoneyTest {

	public static void main(String[] args) {
		Money five  = new Money( 5 );
        Money two   = new Money( 2 );
        Money three = new Money( 3 );
        Money ten   = new Money( 10 );
        
        if(    five.equals( two.add( three ) ) //5  2+3
            && three.equals( five.minus( two ) )//3  5-2
            && ten.equals( five.multiply( two ) )//10  5*2
            && two.equals( ten.devide( five ) ) )  {//10  10/5
            System.out.println( "Money Class 구현을 완료 하였습니다." );
        }
	}
}
