package lab.treeset;

import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> cities = new TreeSet<>(new CitiesComparator());
		
		// add elements to the comparator
		cities.add("UAE");
		cities.add("Mumbai");
		cities.add("NewYork");
		cities.add("Hyderabad");
		cities.add("Karachi");
		cities.add("Xanadu");
		cities.add("Lahore");
		cities.add("Zagazig");
		cities.add("Yingkou");

		// print the contents of TreeSet
		System.out.println("TreeSet: " + cities);

	}

}
