package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {

	public static void main(String[] args) {
		Set<Gugudan> set = new HashSet<>();

		Gugudan g1 = new Gugudan(2, 3);
		Gugudan g2 = new Gugudan(9, 8);
		Gugudan g3 = new Gugudan(3, 2);
		Gugudan g4 = new Gugudan(2, 3);
		Gugudan g5 = new Gugudan(1, 7);

		set.add(g1);
		set.add(g2);
		set.add(g3);
		set.add(g4);
		set.add(g5);

		for (Gugudan g : set) {
			System.out.println(g);
		}

	}

}
