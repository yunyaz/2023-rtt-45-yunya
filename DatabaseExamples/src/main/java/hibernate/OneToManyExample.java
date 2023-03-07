package hibernate;

import java.time.LocalDate;

public class OneToManyExample {

	public static void main(String[] args) {

		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		PaymentDAO paymentDao = new PaymentDAO();
		
//		Employee e = employeeDao.findById(1166);
//		System.out.println(e);
//		
//		for (Customer customer : e.getCustomers()) {
//			System.out.println(customer);
//		}
//
//		Customer customer = new Customer();
//		customer.setCustomerName("Hibernate customer 3");
//		customer.setContactFirstname("First Name");
//		customer.setContactLastname("Last Name");
//		customer.setPhone("555-555-5555");
//		customer.setAddressLine1("Address Line 1");
//		customer.setCity("Denver");
//		customer.setState("CO");
//		customer.setCountry("USA");
//		customer.setEmployee(e);
//		
//		customerDao.insert(customer);
		
//		e.getCustomers().add(customer);
//		employeeDao.update(e);
		
		Customer c = customerDao.findById(103);
		System.out.println(c);
		
		for (Payment payment : c.getPayments()) {
			System.out.println(payment);
		}
		
		Payment payment = new Payment();
		payment.setCheckNumber("AB123456");
		payment.setPaymentDate(LocalDate.of(2023, 03, 07));
		payment.setAmount(1234.56);
		payment.setCustomer(c);
		
		paymentDao.insert(payment);
		

	}

}
