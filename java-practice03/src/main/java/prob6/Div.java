package prob6;

public class Div extends Calculate {

	@Override
	public String calculate() {
		double result = (double)getA() / (double)getB();
		
		return Double.toString(result);
	}

}
