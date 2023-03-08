package lab.treemapDirectory;

public class TestPhoneDirectory {

	public static void main(String[] args) {

		PhoneDirectory directory = new PhoneDirectory();
		System.out.println("This program creates a PhoneDirectoryWithTreeMap and adds several entries.");
		System.out.println("It then prints the contents of directory and does a few lookups.");
		System.out.println();
		directory.putNumber("Fred", "555-1234");
		directory.putNumber("Barney", "555-2345");
		directory.putNumber("Wilma", "555-3456");
		directory.putNumber("Wilma", "555-3456");
		directory.putNumber("Wilma", "555-2563");
		
		try {
			directory.putNumber("James", null);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
//		directory.putNumber(null,"555-2853");
		System.out.println("Contents are:");
		System.out.println();
		directory.print();
		
		System.out.println();
		System.out.println("Number for Fred is " + directory.getNumber("Fred"));
		System.out.println("Number for Wilma is " + directory.getNumber("Wilma"));
		System.out.println("Number for Tom is " + directory.getNumber("Tom"));
		System.out.println("Number for Tom is " + directory.getNumber("Alex"));
		// The output from the last line should be null.

	}

}
