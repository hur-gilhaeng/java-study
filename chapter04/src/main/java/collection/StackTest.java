package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		System.out.println("Stack test");
		System.out.println("==============");
		Stack<String> st = new Stack<>();
		
		st.push("1_super_man");
		st.push("2_bat_man");
		st.push("3_iron_man");
		
		while(!st.isEmpty()) {
			String str = st.pop();
			System.out.println(str);
		}
		
		System.out.println("==============");
		
		st.push("1_super_man");
		st.push("2_bat_man");
		st.push("3_iron_man");
		
		System.out.println(st.pop());
		System.out.println(st.peek());
		
		System.out.println("==============");
		
		while(!st.isEmpty()) {
			String str = st.pop();
			System.out.println(str);
		}
	}

}
