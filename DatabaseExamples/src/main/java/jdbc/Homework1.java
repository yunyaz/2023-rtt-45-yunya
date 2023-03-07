package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Homework1 {
	
	// make this in a new Homework1 class
	// I want to see a list of all customers that have made a payment larger than <amount> in a particular <state>
    // Print the checkNumber, amount (formatted to $#.00 ), and the customer name ordred by the largest amount first
    // input variables for the scanner are 1) the amount and 2) 2 digit state code.
	
	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------\n");
		try {

			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter an amount:");
			
			int amount = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the state:");
			
			String state = scanner.nextLine();
			
			String SelectSQL = "SELECT p.checkNumber, format(p.amount, 2) AS amount, c.customerName "
					+ "FROM payments AS p, customers AS c "
					+ "WHERE p.customerNumber = c.customerNumber AND p.amount > ? AND c.state = ? "
					+ "ORDER BY p.amount DESC";
			
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1, amount);
			stmt.setString(2, state);
			
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String checkNumber = result.getString("checkNumber");
				String accountAmount = result.getString("amount");
				String name = result.getString("customerName");
				System.out.println(checkNumber + " | " + "$" + accountAmount + " | " + name);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}

}
