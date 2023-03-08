package classExamples.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("Steven");
		names.add("Eric");
		names.add("Jessica");
		names.add("Ellen");

		names.stream().forEach(name -> {
			System.out.println(name);
		});
		
		System.out.println("============");
		
		names.sort(Comparator.comparingInt(String::length).thenComparing(x -> x.toLowerCase()));
		
		names.stream().forEach(name -> {
			System.out.println(name);
		});
		
		System.out.println("============");
		
		List<String> sortedByLength = names.stream()
				.sorted((a, b) -> {
					int diff = a.length() - b.length();
					if (diff == 0) {
						diff = a.charAt(0) - b.charAt(0);
					}
					return diff;
				})
				.collect(Collectors.toList());
		
		sortedByLength.stream().forEach(name -> {
			System.out.println(name);
		});
		
		
		System.out.println("============");
		
		List<String> sortedList = names.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		sortedList.stream().forEach(name -> {
			System.out.println(name);
		});
		
		System.out.println("============");
		
		sortedList.removeIf(name -> name.contains("n"));
		
		sortedList.stream().forEach(name -> {
			System.out.println(name);
		});
		
	}

}
