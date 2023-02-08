package assignment.loops;

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		Loops problems = new Loops();
		problems.problem3();

	}
	
	
	public void problem1() {
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 12; j++) {
				int num = i * j;
				System.out.print(num + " ");
				if (num < 10) {
					System.out.print("  ");
				} else if (num < 100) {
					System.out.print(" ");
				}
			}
			System.out.println("\n");
		}
	}
	
	
	public void problem2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter two positive numbers:");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		int gcd = 0;
		for (int i = 1; i <= Math.min(num1, num2); i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		System.out.println("The greatest common divisor of " + num1 + " and " + num2 + " is " + gcd);
	}
	
	
	public void problem3() {
		int initialTuition = 10000;
		int tuition = initialTuition;
		int year = 0;
		while (tuition < initialTuition * 2) {
			tuition += tuition * 0.07;
			year++;
			System.out.println("The tuition for year " + year + " is $" + tuition);
		}
		
	}
}
