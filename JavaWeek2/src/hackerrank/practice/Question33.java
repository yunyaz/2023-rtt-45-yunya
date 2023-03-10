package hackerrank.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question33 {

	public static void main(String[] args) {

		List<String> name = new ArrayList<>(Arrays.asList("ball", "box", "ball", "ball", "box"));
		List<Integer> price = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));
		List<Integer> weight = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 3));

		int result = numDuplicates(name, price, weight);
		System.out.println(result);

	}

	public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
		// Write your code here
int count = 0;
        
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < name.size(); i++) {
            String iName = name.get(i);
            if (!map.containsKey(iName)) {
                map.put(iName, new ArrayList<Integer>(Arrays.asList(i)));
                continue;
            } else {
                List<Integer> list = map.get(iName);
                for (int j = 0; j < list.size(); j++) {
                    int index = list.get(j);
                    if (price.get(i) == price.get(index) && weight.get(i) == weight.get(index)) {
                        count++;
                        break;
                    } else {
                        map.get(iName).add(i);
                    }
                }
            }
        }
        
        return count;
	}

}
