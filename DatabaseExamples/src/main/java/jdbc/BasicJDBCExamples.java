package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BasicJDBCExamples {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------\n");
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Please enter a first name you want to look up");
			
			String name = scanner.nextLine();
			
			String SelectSQL = "Select * FROM employees where firstName = ? or lastName = ?";
			
//			Statement stmt = connection.createStatement();
			
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setString(1, name);
			stmt.setString(2, name);
			
//			ResultSet result = stmt.executeQuery(SelectSQL);
			
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String EmployeeID = result.getString("employeeNumber");
				String fname = result.getString("firstName");
				String lname = result.getString("lastName");
				String email = result.getString("email");
				System.out.println(EmployeeID + " | " + fname + "|" + lname + "|" + email);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}

}
