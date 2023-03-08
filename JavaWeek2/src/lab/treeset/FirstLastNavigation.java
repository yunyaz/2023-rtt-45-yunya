package lab.treeset;

import java.util.TreeSet;

public class FirstLastNavigation {

	public static void main(String[] args) {

		TreeSet<Integer> numbers = new TreeSet<>();
		numbers.add(2);
		numbers.add(5);
		numbers.add(6);
		System.out.println("TreeSet: " + numbers);

		// Using the first() method
		int first = numbers.first();
		System.out.println("First Number: " + first);

		// Using the last() method
		int last = numbers.last();
		System.out.println("Last Number: " + last);

	}

}
