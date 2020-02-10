package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		
		goods.name = "nikon";
		goods.price = 400;
		goods.countStock = 30;
		goods.setCountSold(50);
		//goods.price = 10000;
		
		System.out.println(Goods.countOfGoods);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		goods2.name = "nikon2";
		goods3.name = "nikon3";

		
		System.out.println(Goods.countOfGoods);
		System.out.println(goods.countStock);
	}

}
