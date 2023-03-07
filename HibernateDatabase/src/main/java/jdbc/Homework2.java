package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework2 {

	// Homework 2
	// you dont need a scanner for this
	// write a query that returns the distict state where we have offices where the
	// state is not null
	// loop over the result set and for each row do another query to select the
	// customers that are in that state
	// print a message "-------------------------- <state> ----------------------"
	// and then the customer number and customer name for that state
	// make a new statement for each query
	// ---------------------------------- CA -------------------------------
	// 1001 Super Scale Inc.
	// ---------------------------------- NY -------------------------------

	public static void main(String[] args) {

		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------\n");
		try {

			Connection connection = DriverManager.getConnection(dburl, user, password);

			String SelectSQL = "SELECT DISTINCT state FROM offices WHERE state IS NOT NULL;";

			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery(SelectSQL);
			while (result.next()) {
				String state = result.getString("state");
				System.out.println("-------------------------- " + state + " --------------------------");
				
				SelectSQL = "SELECT customerNumber, customerName FROM customers WHERE state = ?";
				
				PreparedStatement pStmt = connection.prepareStatement(SelectSQL);
				pStmt.setString(1, state);
				
				ResultSet res = pStmt.executeQuery();
				
				while (res.next()) {
					int customerNumber = res.getInt("customerNumber");
					String customerName = res.getString("customerName");
					System.out.println(customerNumber + "\t" + customerName);
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
