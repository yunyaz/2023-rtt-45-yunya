package exam.sba;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
	
	public static void main(String[] args) {
		
		// how to transfer an array into an arraylist
		
		String[] arr = { "zero", "one", "two", "three", "four", "five" };
		Question1 q1 = new Question1();
		q1.convert(arr);
		
		q1.replace(2);
		q1.replace(4);
		
		List<String> compact = q1.compact();

	}
	
	
	
	private ArrayList<String> list;
	
	// in the constructor create a new arraylist
	Question1() {
		list = new ArrayList<>();
	}
	
	// how to convert an array of strings to a list of strings
	public void convert(String[] arr) {
		for (String str : arr) {
			list.add(str);
		}
	}
	
	// in an arraylist write the value at idx to be an empty string
	// print a message saying what the value of the position in the list is and the value you are overwriting with
	public void replace(int idx) {
		String value = list.get(idx);
		list.set(idx, "");
		System.out.println("The value at position " + idx + " was " + value + " . The value is " + list.get(idx) + " now.");
		
		System.out.println(list);
		
	}
	
	// remove all values in the arraylist that are empty strings
	public ArrayList<String> compact() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("")) {
				list.remove(i);
			}
		}
		System.out.println(list);
		
		return list;
	}

}
