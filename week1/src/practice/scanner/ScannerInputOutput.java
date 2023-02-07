package practice.scanner;

import java.util.Scanner;

public class ScannerInputOutput {

	public static void main(String[] args) {
		
		/*
		 * In this challenge, you must read  integers from stdin and then print them to stdout. Each integer must be printed on a new line.
		 */
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		/*
		 * In this challenge, you must read an integer, a double, and a String from stdin
		 */
		
		int i = scanner.nextInt();
		double d = scanner.nextDouble();
		
		/* Need to use extra scanner.nextLine();
		 * use the nextLine() method immediately following the nextInt() method, 
		 * recall that nextInt() reads integer tokens; 
		 * because of this, the last newline character for that line of integer input is still queued in the input buffer 
		 * and the next nextLine() will be reading the remainder of the integer line (which is empty).
		 */
		scanner.nextLine();
		String s = scanner.nextLine();
		
		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
		
	}

}
