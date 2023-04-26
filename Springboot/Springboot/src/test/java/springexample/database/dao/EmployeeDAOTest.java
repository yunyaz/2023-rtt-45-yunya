package springexample.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springexample.database.dao.EmployeeDAO;
import springexample.database.entity.Employee;

@SpringBootTest
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDao;

    @Test
    public void findWithOfficeName() {
        employeeDao.findWithOfficeName();
    }

    @Test
    public void findById() {
        Employee e = employeeDao.findById(1002);

        Assertions.assertEquals(e.getFirstName(), "Diane");
        Assertions.assertEquals(e.getLastName(), "Murphy");
    }

    @Test
    @Order(0)
    public void createUser() {
        // given
        Employee given = new Employee();
        given.setEmail("test@gmail.com");
        given.setFirstName("John");
        given.setLastName("Doe");
        given.setJobTitle("Manager");
        given.setReportsTo(1002);

        // when
        employeeDao.save(given);

        // then
        Employee actual = employeeDao.findByEmail("test@gmail.com");

        Assertions.assertEquals(given.getFirstName(), actual.getFirstName());
    }
}
