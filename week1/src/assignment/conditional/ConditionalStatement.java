package assignment.conditional;

import java.util.Scanner;

enum Status {
	Single,
	MarriedFilingJointly,
	MarriedFilingSeparately,
	HeadOfHousehold
}

public class ConditionalStatement {

	public static void main(String[] args) {
		
		ConditionalStatement problems = new ConditionalStatement();
		
		problems.problem7();

	}
	
	
	public void problem1() {
		int x = 7;
		if (x < 10) {
			System.out.println("Less than 10");
		}
	}
	
	
	public void problem2() {
		int x = 7;
		if (x < 10) {
			System.out.println("Less than 10");
		} else {
			System.out.println("Greater than 10");
		}
	}
	
	
	public void problem3() {
		int x = 15;
		if (x < 10) {
			System.out.println("Less than 10");
		} else if (x < 20) {
			System.out.println("Between 10 and 20");
		} else {
			System.out.println("Greater than or equal to 20");
		}
	}
	
	
	public void problem4() {
		int x = 15;
		if (x < 10 || x > 20) {
			System.out.println("Out of range");
		} else {
			System.out.println("In range");
		}
	}
	
	
	public void problem5() {
		Scanner scanner = new Scanner(System.in);
		double score = scanner.nextDouble();
		
		if (score < 0 || score > 100) {
			System.out.println("Score out of range");
		} else if (score >= 90) {
			System.out.println("Grade for " + score + " is A.");
		} else if (score >= 80) {
			System.out.println("Grade for " + score + " is B.");
		} else if (score >= 70) {
			System.out.println("Grade for " + score + " is C.");
		} else if (score >= 60) {
			System.out.println("Grade for " + score + " is D.");
		} else {
			System.out.println("Grade for " + score + " is F.");
		}
	}
	
	
	public void problem6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number between 1 and 7");
		int day = scanner.nextInt();
		
		switch (day) {
			case 1: 
				System.out.println("Monday");
				break;
			case 2: 
				System.out.println("Tuesday");
				break;
			case 3: 
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thursday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
			case 7:
				System.out.println("Sunday");
			default:
				System.out.println("Out of range");
		}
	}
	
	
	
	public void problem7() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter filing status from the following 4 statuses: Single, "
				+ "MarriedFilingJointly, MarriedFilingSeparately, HeadOfHousehold");
		Status status = Status.valueOf(scanner.nextLine());
		
		System.out.println("Enter income");
		int income = scanner.nextInt();
		
		double tax = 0;
		
		switch (status) {
			case Single: {
				if (income <= 8350) {
					tax = income * 0.1;
				} else if (income <= 33950) {
					tax = income * 0.15;
				} else if (income <= 82250) {
					tax = income * 0.25;
				} else if (income <= 171550) {
					tax = income * 0.28;
				} else if (income <= 372950) {
					tax = income * 0.33;
				} else {
					tax = income * 0.35;
				}
				break;
			}
			case MarriedFilingJointly: {
				if (income <= 16700) {
					tax = income * 0.1;
				} else if (income <= 67900) {
					tax = income * 0.15;
				} else if (income <= 137050) {
					tax = income * 0.25;
				} else if (income <= 208850) {
					tax = income * 0.28;
				} else if (income <= 372950) {
					tax = income * 0.33;
				} else {
					tax = income * 0.35;
				}
				break;
			}
			case MarriedFilingSeparately: {
				if (income <= 8350) {
					tax = income * 0.1;
				} else if (income <= 33950) {
					tax = income * 0.15;
				} else if (income <= 68525) {
					tax = income * 0.25;
				} else if (income <= 104425) {
					tax = income * 0.28;
				} else if (income <= 186475) {
					tax = income * 0.33;
				} else {
					tax = income * 0.35;
				}
				break;
			}
			case HeadOfHousehold: {
				if (income <= 11950) {
					tax = income * 0.1;
				} else if (income <= 45500) {
					tax = income * 0.15;
				} else if (income <= 117450) {
					tax = income * 0.25;
				} else if (income <= 190200) {
					tax = income * 0.28;
				} else if (income <= 372950) {
					tax = income * 0.33;
				} else {
					tax = income * 0.35;
				}
				break;
			}
			default: 
				System.out.println("Wrong input");
		}
		
		System.out.printf("You need to pay tax: $%.2f", tax);

	}

}
