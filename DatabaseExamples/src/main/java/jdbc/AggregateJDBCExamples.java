package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AggregateJDBCExamples {
	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------\n");
		try {
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Please enter an amount");
			
			int amount = scanner.nextInt();
			
			String SelectSQL = "select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin "
					+ "from orders o, orderdetails od, products p, customers c "
					+ "where o.orderNumber = od.orderNumber "
					+ "and od.productCode = p.productCode "
					+ "and o.customerNumber = c.customerNumber "
					+ "group by c.customerNumber "
					+ "having avg((MSRP - buyPrice)*quantityOrdered) > ? "
					+ "order by avg_margin desc;";
			
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1, amount);
			
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int customerNumber = result.getInt("customerNumber");
				String customerName = result.getString("customerName");
				double avgMargin = result.getDouble("avg_margin");
				System.out.println(customerNumber + " | " + customerName + " | " + avgMargin);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
}
