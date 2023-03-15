package jpa.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Student;

public class StudentDAOTest {
	
	private static StudentDAO studentDao;
	
	@BeforeAll
	public static void setUp() {
		studentDao = new StudentDAO();
	}
	
	@Test
	public void testGetStudentByEmail() {
		Student expected = new Student();
		expected.setSId(6);
		expected.setSEmail("hguerre5@deviantart.com");
		expected.setSName("Harcourt Guerre");
		expected.setSPassword("OzcxzD1PGs");
		
		Student actual = studentDao.getStudentByEmail("hguerre5@deviantart.com");
		
		Assertions.assertEquals(expected.getSId(), actual.getSId());
		Assertions.assertEquals(expected.getSEmail(), actual.getSEmail());
		Assertions.assertEquals(expected.getSName(), actual.getSName());
		Assertions.assertEquals(expected.getSPassword(), actual.getSPassword());
		
	}

}
