package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		System.out.println("Vector01");

		v.addElement("둘리1");
		v.addElement("둘리2");
		v.addElement("둘리3");

		// 순회1
		int count = v.size();
		for(int i = 0 ;i<count;i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		// 제거
		
		v.removeElementAt(1);
		
		System.out.println("====");
		
		// 순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
	}

}
