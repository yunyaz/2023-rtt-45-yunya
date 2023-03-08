package classExamples.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String, String> strMap = new HashMap<>();
		strMap.put("key1", "value1");
		strMap.put("key2", "value2");
		strMap.put("key3", "value3");
		strMap.put("key4", "value4");
		
		for (String key : strMap.keySet()) {
			System.out.println(key + " = " + strMap.get(key));
		}
		
		System.out.println("=======================");
		
		Map<String, Integer> strIntMap = new HashMap<>();
		strIntMap.put("key", 1);
		
		Map<Integer, String> numMap = new HashMap<>();
		numMap.put(1, "one");
		numMap.put(2, "two");
		numMap.put(3, "three");
		numMap.put(4, "four");
		numMap.put(5, "five");
		numMap.put(6, "six");
		
		System.out.println(numMap.get(3));
		
		numMap.put(3, "THREE");
		
		System.out.println(numMap.get(3));
	}

}
