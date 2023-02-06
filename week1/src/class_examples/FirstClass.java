package class_examples;

import java.util.Scanner;

public class FirstClass {
	
	public static void main(String[] args) {
		/*
		 * This can be used for a much longer comment that
		 * spans multiple lines.
		 */
		
		// The escape symbol back slash \
		System.out.println("First \"Java \\Program");
		
		
		// This is a comment
		int i = 5 + 5;
		System.out.println("5 + 5 = " + i);
		
		String utf_8 = "¼";
		
		System.out.println(utf_8);
		
		System.out.println("This will print on\rtwo lines");
		
		char a = '\u00BC';
		
		System.out.println(a);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = input.nextLine();
		
		System.out.println("My name is " + name);
		
		input.close();

	}

}
