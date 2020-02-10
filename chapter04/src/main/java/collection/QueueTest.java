package collection;

import java.util.*;

public class QueueTest {

	public static void main(String[] args) {
		System.out.println("Queue test");
		System.out.println("==============");
		Queue<String> q = new LinkedList<>();
		
		q.offer("1_super_man");
		q.offer("2_bat_man");
		q.offer("3_iron_man");
		
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		System.out.println("=======");
		
		q.offer("1_super_man");
		q.offer("2_bat_man");
		q.offer("3_iron_man");;
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		
		System.out.println("=======");
		
		while(!q.isEmpty()) {
			String str = q.poll();
			System.out.println(str);
		}
		
		
	}

}
