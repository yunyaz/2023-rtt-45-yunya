package hackerrank.SBA;

////<<<<<======== Click here to expand the locked stub code
import java.util.ArrayList;

interface MyList {
	void convert(String[] a);

	void replace(int idx);

	ArrayList<String> compact();
}
/*
 * This is here only for visibility. Please do not take the code below out of
 * the comments. import java.util.*;
 * 
 * interface MyList{ void convert(String[] a); void replace(int idx);
 * ArrayList<String> compact(); }
 * 
 * This is here only for visibility. Please do not take the code above out of
 * the comments.
 */

//================ PLEASE WRITE CODE HERE =============

//Write your implementation of the InvalidStringException and the ArrayToList classes below

class InvalidStringException extends Exception {

	InvalidStringException(String str) {
		super(str);
	}

}

class ArrayToList implements MyList {

	ArrayList<String> arrayToList;

	ArrayToList() {
		arrayToList = new ArrayList<>();
	}

	public void convert(String[] a) {
		for (int i = 0; i < a.length; i++) {
			arrayToList.add(a[i]);
			System.out.println("I have added the string: " + a[i] + " at the index: " + i);
		}
	}

	public void replace(int idx) {
		String str = arrayToList.get(idx);
		arrayToList.set(idx, "");
		System.out.println("I have replaced the string: " + str + " with a null string");
	}

	public ArrayList<String> compact() {
		ArrayList<String> newArrayList = new ArrayList<>();
		for (int i = 0; i < arrayToList.size(); i++) {
			if (!arrayToList.get(i).equals("")) {
				newArrayList.add(arrayToList.get(i));
			}
		}
		return newArrayList;
	}
}