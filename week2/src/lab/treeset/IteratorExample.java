package lab.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class IteratorExample {

	public static void main(String[] args) {

		TreeSet<Integer> num_Treeset = new TreeSet<>();
		num_Treeset.add(20);
		num_Treeset.add(5);
		num_Treeset.add(15);
		num_Treeset.add(25);
		num_Treeset.add(10);

		// Call iterator() method to define Iterator for TreeSet
		Iterator<Integer> iter_set = num_Treeset.iterator();
		System.out.print("TreeSet using Iterator: ");

		// Access TreeSet elements using Iterator
		while (iter_set.hasNext()) {
			System.out.print(iter_set.next());
			System.out.print(", ");
		}
		
//		System.out.println();
//		for (int num : num_Treeset) {
//			System.out.print(num + " ");
//		}

	}

}
