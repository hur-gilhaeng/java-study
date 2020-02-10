package prob6;

public class Mul extends Calculate {

	@Override
	public String calculate() {
		int result = getA() * getB();
		
		return Integer.toString(result);
	}

}
