package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		for(int i=0;i<COUNT_GOODS;i++) {
			goods[i] = new Goods(); // Goods타입으로 이루어진 배열의 빈 공간에 new로 객체를 생성해 줍시다.

			System.out.print(">> ");
			String line = scanner.nextLine();

			String[] tokens = line.split(" ");

			if(tokens.length != 3) {
				System.out.println(">> "+(i+1)+"번째 줄을 잘못 입력 했습니다! 다시입력해주세요!");
				i--;
				continue;
			}

			String name = tokens[0];
			goods[i].setName(name);

			if(!isNum(tokens[1])) {
				System.out.println(">> "+(i+1)+"번째 줄의 물품가격을 잘못 입력 했습니다! 다시입력해주세요!");
				i--;
				continue;
			}
			int price = Integer.parseInt(tokens[1]);
			
			goods[i].setPrice(price);

			if(!isNum(tokens[2])) {
				System.out.println(">> "+(i+1)+"번째 줄의 물품재고를 잘못 입력 했습니다! 다시입력해주세요!");
				i--;
				continue;
			}
			int countStock = Integer.parseInt(tokens[2]);
			goods[i].setCountStock(countStock);

		}

		for(int i=0;i<COUNT_GOODS;i++) {
			System.out.print(goods[i].getName()+"(가격: "+goods[i].getPrice()+")이 ");
			System.out.println(goods[i].getCountStock()+"개 입고 되었습니다.");
		}

		scanner.close();
	}
	private static boolean isNum(String s) {
		boolean result = s.replaceAll("[+-]?\\d+", "").equals("");
		return result;
	}
}
