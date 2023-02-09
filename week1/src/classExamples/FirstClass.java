package classExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstClass {

	public static void main(String[] args) {
		/*
		 * This can be used for a much longer comment that spans multiple lines.
		 */

		// The escape symbol back slash \
//		System.out.println("First \"Java \\Program");
//		
//		
//		// This is a comment
//		int i = 5 + 5;
//		System.out.println("5 + 5 = " + i);
//		
//		String utf_8 = "¼";
//		
//		System.out.println(utf_8);
//		
//		System.out.println("This will print on\rtwo lines");
//		
//		char a = '\u00BC';
//		
//		System.out.println(a);
//		
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter your name:");
//		String name = input.nextLine();
//		
//		System.out.println("My name is " + name);
//		
//		input.close();
//		

		FirstClass problem = new FirstClass();
//		problem.forLoop();
//		problem.forLoopList();
//		problem.maxRandomValue(1, 100, 10);

	}

	public void forLoop() {
		for (int i = 10; i <= 30; i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.println(i);
		}

		System.out.println("=========");

		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
		}

		System.out.println("=========");

		for (int i = 10; i <= 30; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
				break;
			}
		}
	}

	public void forLoopList() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		for (int num : list) {
			System.out.println(num);
		}
	}
	
//	public void maxRandomValue(int min, int max, int size) {
//		List<Integer> list = new ArrayList<>();
//		
//		for (int i = 0; i < size; i++) {
//			Random rand = new Random();
//			int num = rand.nextInt((max - min) + 1) + min;
//			list.add(num);
//			System.out.println(list.get(i));
//		}
//		
//		int minValue = list.get(0);
//		int maxValue = list.get(0);
//		
//		for (int num : list) {
//			if (num < minValue) {
//				minValue = num;
//			} else if (num > maxValue) {
//				maxValue = num;
//			}
//		}
//		System.out.println("Min = " + minValue);
//		System.out.println("Max = " + maxValue);
//		
//	}
	
	public void maxRandomValue(int min, int max, int size) {
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			Random rand = new Random();
			arr[i] = rand.nextInt((max - min) + 1) + min;
			System.out.println(arr[i]);
		}
		
		int minValue = arr[0];
		int maxValue = arr[0];
		
		for (int num : arr) {
			if (num < minValue) {
				minValue = num;
			} else if (num > maxValue){
				maxValue = num;
			}
		}
		
		System.out.println("Min = " + minValue);
		System.out.println("Max = " + maxValue);
	}
	
	

}
