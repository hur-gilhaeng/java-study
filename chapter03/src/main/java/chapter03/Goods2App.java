package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		
		Goods2 goods = new Goods2();
		
		goods.setName("RaMen");
		goods.setPrice(1000);
		goods.setCountStock(30);
		goods.setCountSold(17);
		
		goods.showInfo();
		
		int price = goods.calcDiscountPrice(0.5);
		System.out.println("할인가 :"+price);
		
		System.out.println("물품명: "+goods.getName());
		System.out.println("가격: "+goods.getPrice());
		System.out.println("재고량: "+goods.getCountStock());
		System.out.println("판매량: "+goods.getCountSold());
		
		Goods2 goods2 = new Goods2("tv",10000,1,3);
		goods2.showInfo();
	}

}
