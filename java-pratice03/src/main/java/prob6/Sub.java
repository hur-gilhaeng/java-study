package prob6;

public class Sub extends Calculate {

	@Override
	public String calculate() {
		int result = getA() - getB();
		
		return Integer.toString(result);
	}

}
