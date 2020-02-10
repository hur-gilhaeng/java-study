package prob05;

public class MyBase extends Base {

	@Override
	public void service(String state) {
		// state가 null일 가능성이 있기때문에
		// NullpointException이 발생할 수 있다.
		// 따라서 아래의 코드가 안정성이 상대적으로 높다. 
		// "오후".equals(state)
		if( state.equals( "오후" ) ) {
			afternoon();
		} else {
			super.service(state);
		}
	}
	
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	public void afternoon(){
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}
	
}