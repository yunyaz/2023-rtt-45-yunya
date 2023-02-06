package practice.variables;

public class CoreJavaVariables {

	public static void main(String[] args) {
		
		/*
		 * Write a program that declares 2 integer variables, assigns an integer to each, 
		 * and adds them together. Assign the sum to a variable. Print out the result.
		 */
		
		int a = 5;
		int b = 8;
		int c = a + b;
		System.out.println(c);
		
		
		/* Write a program that declares 2 double variables, assigns a number to each, 
		 * and adds them together. Assign the sum to a variable. Print out the result.
		 */
		
		double d = 4.8;
		double e = 7.5;
		double f = d + e;
		System.out.println(f);
		
		
		/*
		 * Write a program that declares an integer variable and a double variable, assigns numbers to each, 
		 * and adds them together. Assign the sum to a variable. 
		 * Print out the result. What variable type must the sum be?
		 */
		
		int g = 12;
		double h = 9.6;
		double i = g + h;
		System.out.println(i);
		
		
		/*
		 * Write a program that declares 2 integer variables, assigns an integer to each, 
		 * and divides the larger number by the smaller number. Assign the result to a variable. 
		 * Print out the result. Now change the larger number to a decimal. 
		 * What happens? What corrections are needed?
		 */
		
		// int j = 25;
		// int k = 7;
		// int l = j / k;
		// System.out.println(l);
		
		double j = 25.6;
		int k = 7;
		double l = j / k;
		System.out.println(l);
		
		
		/*
		 * Write a program that declares 2 double variables, assigns a number to each, 
		 * and divides the larger by the smaller. Assign the result to a variable. Print out the result. 
		 * Now, cast the result to an integer. Print out the result again.
		 */
		
		double m = 16.7;
		double n = 3.3;
		double o = m / n;
		System.out.println(o);
		System.out.println((int)o);
		
		
		/*
		 * Write a program that declares two integer variables, x, and y, and assigns 5 to x and 6 to y. 
		 * Declare a variable q and assign y/x to it and print q. 
		 * Now, cast y to a double and assign it to q. Print q again.
		 */
		
		int x = 5;
		int y = 6;
		double q = y / x;
		System.out.println(q);
		
		q = (double)y / x;
		System.out.println(q);
		
		
		/*
		 * Write a program that declares a named constant and uses it in a calculation. Print the result.
		 */
		
		final int CONSTANT_NUMBER = 33;
		int r = 5;
		double s = CONSTANT_NUMBER / 5;
		System.out.println(s);
		
		
		/*
		 * Write a program where you create 3 variables that represent products at a cafe. 
		 * The products could be beverages like coffee, cappuccino, espresso, green tea, etc. 
		 * Assign prices to each product. 
		 * Create 2 more variables called subtotal and totalSale 
		 * and complete an “order” for 3 items of the first product, 4 items of the second product, and 2 items of the third product. 
		 * Add them all together to calculate the subtotal.
		 * Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount. 
		 * Be sure to format the results to 2 decimal places.
		 */
		
		double coffee = 2.49;
		double cappuccino = 4.99;
		double expresso = 3.99;
		
		double subtotal = 0.0;
		double totalSale = 0.0;
		
		subtotal = coffee * 3 + cappuccino * 4 + expresso * 2;
		
		final double SALES_TAX = 0.06;
		
		totalSale = subtotal * (1 + SALES_TAX);
		totalSale = totalSale * 100;
		totalSale = (double)((int)totalSale);
		totalSale = totalSale / 100;
		System.out.println("The total for 3 cups of coffee, 4 cups of cappuccino, and 2 cups of expresso is $" + totalSale);
	}

}
