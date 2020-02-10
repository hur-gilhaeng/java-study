package collection;

public class Gugudan {
	private int leftNum;
	private int rightNum;
	
	public Gugudan(int left, int right) {
		this.leftNum = left;
		this.rightNum = right;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (leftNum*rightNum);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
//		Gugudan other = (Gugudan) obj;
//		if (leftNum != other.leftNum)
//			return false;
//		if (rightNum != other.rightNum)
//			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Gugudan [" + leftNum + "*" + rightNum +"="+(leftNum*rightNum)+ "]";
	}
	
}
