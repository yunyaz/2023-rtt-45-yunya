package app;

import java.util.Date;

import controller.CustomerDAO;
import controller.OrderDAO;
import model.Customer;
import model.Order;

public class OrderExample {

	public static void main(String[] args) {
		
		CustomerDAO customerDao = new CustomerDAO();
		OrderDAO orderDao = new OrderDAO();
		
		Order order = orderDao.findById(10100);
		
		System.out.println(order);
		
		Order o = new Order();
		Customer c = customerDao.findById(500);
		o.setCustomer(c);
		o.setOrderDate(new Date());
		o.setRequiredDate(new Date());
		o.setShippedDate(new Date());
		o.setStatus("In process");
		
		orderDao.insert(o);
		

	}

}
