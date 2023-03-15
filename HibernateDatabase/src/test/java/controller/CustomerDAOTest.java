package controller;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import model.Customer;

public class CustomerDAOTest {
	
	private static CustomerDAO customerDao;
	
	@BeforeAll
	public static void setUp() {
		customerDao = new CustomerDAO();
	}
	
	@Test
	public void testFindById() {
		
		// given
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactLastname("Schmitt");
		expected.setContactFirstname("Carine");
		
		// when
		Customer actual = customerDao.findById(103);
		
		// then
//		Assert.assertEquals(expected, actual);
		
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());
	}
	
	
	@ParameterizedTest 
	@CsvSource({
		"103,Atelier graphique,Schmitt,Carine", 
		"112,Signal Gift Stores,King,Jean" 
		})
	public void testFindByIdParameterized(ArgumentsAccessor arguments) {
		
		// given
		Customer expected = new Customer();
		expected.setCustomerName(arguments.getString(1));
		expected.setContactLastname(arguments.getString(2));
		expected.setContactFirstname(arguments.getString(3));
		
		// when
		Customer actual = customerDao.findById(arguments.getInteger(0));
		
		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());
	}

}
