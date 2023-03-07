package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

	public static void main(String[] args) {
		
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate customer");
		customer.setContactFirstname("First Name");
		customer.setContactLastname("Last Name");
		customer.setPhone("555-555-5555");
		customer.setAddressLine1("Address Line 1");
		customer.setCity("Denver");
		customer.setState("CO");
		customer.setCountry("USA");
		
//		customerDao.insert(customer);
		
		Customer first = customerDao.findById(103);
		System.out.println(first.toString());
		
		first.setAddressLine2("This is an update");
		first.setPostalCode("80203");
		first.setCreditLimit(100000.35);
		
//		customerDao.update(first);
		
//		customerDao.delete(first);
		
//		customerDao.deleteById(506);
		
//		List<Customer> firstNames = he.findByContactFirstName("Leslie");
//		for(Customer c : firstNames) {
//			System.out.println(c);
//		}
		
		

	}
	
	

}
