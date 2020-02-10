package prob2;

public class Goods {
	private String name;
	private int price;
	private int countStock;

	public Goods() {
		name = null;
		price = 0;
		countStock = 0;
	}

	public Goods(String name,int price,int countStock) {
		this.name=name;
		this.price = price;
		this.countStock = countStock;
	}

	public void setName(String name){
		this.name=name;
	}
	public void setPrice(int price){
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	public void setCountStock(int countStock){
		this.countStock = countStock;
	}

	public String getName(){
		return name;
	}
	public int getPrice(){
		return price;
	}
	public int getCountStock(){
		return countStock;
	}
}
