package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		System.out.println(s1==s2);
		
		set.add("둘리");
		set.add("마이콜");
		set.add(s1);
		set.add("또치");
		
		System.out.println(set.contains(s2));
		System.out.println(set.size());
		
		// 순회
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		for(String str : set) {
			System.out.println(str);
		}
	}

}
