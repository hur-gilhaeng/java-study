package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
//		Class klass = p.getClass();				// reflection
//		System.out.println(klass.getName());	
		
		System.out.println(p.getClass());		// reflection
		System.out.println(p.hashCode());		// reference value			(x)
												// address					(x)
												// address 기반의 해싱값 (int)	(O)
		System.out.println(p);					
		System.out.println(p.toString());		// getClass() + "@" + hashCode()
	}

}
