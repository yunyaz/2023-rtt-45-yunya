package hackerrank.coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava {

	public static void main(String[] args) {
		CoreJava problem = new CoreJava();
//		problem.getMinDeletions();
//		problem.minTime();
		problem.ItemSeparator();
	}

	public int addNumbers(double d, double e) {
		// Write your code here
		int sum = (int) (d + e);
		return sum;
	}

	public void getMinDeletions() {
		// Write your code here
		String s = "bbeadcebfp";
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			if (i != 0 && s.substring(0, i).contains(Character.toString(c))) {
				continue;
			}
			for (int j = i + 1; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public void minTime() {
		// Write your code here
		
		List<Integer> batchSize = new ArrayList<>(Arrays.asList(3, 2, 5, 7));
		List<Integer> processingTime = new ArrayList<>(Arrays.asList(5, 4, 10, 12));
		List<Integer> numTasks = new ArrayList<>(Arrays.asList(10, 6, 10, 5));
		

		long min = Long.MAX_VALUE;
		for (int i = 0; i < batchSize.size(); i++) {
			int time = (int)Math.ceil((double) numTasks.get(i) / (double) batchSize.get(i)) * processingTime.get(i);
			if (time < min) {
				min = time;
			}
		}
		System.out.println(min);
	}
	
	public void ItemSeparator() {
		String s = "Bread$$##12.5$$##10";
		
        int indexOne = s.indexOf("$$##");
        System.out.println(indexOne);
        
        int indexTwo = s.indexOf("$$##", indexOne + 4);
        System.out.println(indexTwo);
        
        String name = s.substring(0, indexOne);
        Double price = Double.valueOf(s.substring(indexOne + 4, indexTwo));
        Integer quantity = Integer.valueOf(s.substring(indexTwo + 4));
        
        System.out.println(name);
        System.out.println(price);
        System.out.println(quantity);
    }

}
