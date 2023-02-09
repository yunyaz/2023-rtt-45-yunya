package assignment.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAssignment {

	public static void main(String[] args) {
		
		ArrayAssignment problems = new ArrayAssignment();
		
		problems.problem11();

	}
	
	public void problem1() {
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		for (int num : arr) {
			System.out.println(num);
		}
	}
	
	public void problem2() {
		int[] arr = { 13, 5, 7, 68, 2 };
		int length = arr.length;
		int midIndex = length / 2;
		System.out.println(arr[midIndex]);
	}
	
	public void problem3() {
		String[] ss = { "red", "green", "blue", "yellow" };
		System.out.println(ss.length);
		
		String[] ssCopy = ss.clone();
		
		System.out.println(Arrays.toString(ss));
		System.out.println(Arrays.toString(ssCopy));
	}
	
	public void problem4() {
		int[] arr = { 1, 2, 3, 4, 5 };
		arr[5] = 10;
		
		System.out.println(arr[0]);
		System.out.println(arr[arr.length - 1]);
	}
	
	public void problem5() {
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
			System.out.println(arr[i]);
		}
	}
	
	public void problem6() {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i * 2;
			System.out.println(arr[i]);
		}
	}
	
	public void problem7() {
		int[] arr = { 1, 2, 3, 4, 5 };
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 2) {
				continue;
			}
			System.out.println(arr[i]);
		}
	}
	
	public void problem8() {
		String[] ss = { "a", "b", "c", "d", "e" };
		
		String temp = ss[0];
		ss[0] = ss[2];
		ss[2] = temp;
		
		for (String s : ss) {
			System.out.println(s);
		}
	}
	
	public void problem9() {
		int[] arr = { 4, 2, 9, 13, 1, 0 };
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.print("Array in ascending order: ");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1] + "\n");
		
		System.out.println("The smallest number is " + arr[0]);
		System.out.println("The biggest number is " + arr[arr.length - 1]);
	}
	
	public void problem10() {
		String[] ss = { "5", "a", "b", "c", "8.50" };
		
		for (String s : ss) {
			System.out.println(s);
		}
	}
	
	public void problem11() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many favorite things do you have?");
		int length = scanner.nextInt();
		
		String[] things = new String[length];
		
		for (int i = 0; i < length; i++) {
			System.out.print("Enter your thing: ");
			things[i] = scanner.next();
		}
		
		System.out.println("Your favorite things are: ");
		for (String thing : things) {
			System.out.print(thing + " ");
		}
		scanner.close();
	}

}
