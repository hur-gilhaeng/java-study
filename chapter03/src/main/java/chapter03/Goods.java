package chapter03;

public class Goods {
	public static int countOfGoods;
	
	public Goods() {
		Goods.countOfGoods++; // countOfGoods++; 과 같음
	}
	
	String name;
	public int price;
	protected int countStock;
	private int countSold;
	
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountSold() {
		return countSold;
	}
}
