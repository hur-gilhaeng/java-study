package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		System.out.println("ArrayList");

		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		// 순회1
		int count = list.size();
		for(int i = 0 ;i<count;i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		// 제거
		
		list.remove(1);
		//list.remove(new String("둘리"));
		System.out.println("====");
		
		// 순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		// 중간삽입
		list.add(1,"또치");
		System.out.println("====");
		
		// 순회3 (for~each)
		for(String s : list) {
			System.out.println(s);
		}
	}

}
