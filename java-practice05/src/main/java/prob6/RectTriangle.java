package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;
	
	public RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		double result;
		result = (width * height)*0.5;
		return result;
	}

	@Override
	public double getPerimeter() {
		double result;
		result = width + height + Math.sqrt(width*width + height*height);
		return result;
	}

}
