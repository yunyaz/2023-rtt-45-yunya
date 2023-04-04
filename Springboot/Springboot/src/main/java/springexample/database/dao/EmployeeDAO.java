package springexample.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexample.database.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    // this is a JPA hibernate query
    @Query("From Employee e")
    List<Employee> getAllEmployees();

    Employee findById(Integer id);

    // JPA query using built-in function
    List<Employee> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    // native query
    @Query(value="select * from employees where lower(firstname) = lower(:firstName) or lower(lastname) = lower(:lastName);", nativeQuery = true)
    List<Employee> usingNativeQueryFindByFirstNameOrLastName(String firstName, String lastName);

    // native query using LIKE for partial match using lower()
    @Query(value="select * from employees where lower(firstName) like lower(concat('%', :firstName, '%')) or lower(lastName) like lower(concat('%', :lastName, '%'));", nativeQuery = true)
    List<Employee> usingNativeQueryFindByLowerPartialName(String firstName, String lastName);

    // JPA hibernate query
    @Query("Select e from Employee e where lower(e.firstName) = lower(:firstName) or lower(e.lastName) = lower(:lastName)")
    List<Employee> usingJPAQueryFindByFirstNameOrLastName(String firstName, String lastName);

    // JPA hibernate query using LIKE for partial match
    @Query("Select e from Employee e where lower(e.firstName) LIKE %:firstName% or lower(e.lastName) LIKE %:lastName%")
    List<Employee> usingJPAQueryFindByPartialName(String firstName, String lastName);

    // JPA hibernate query using LIKE for partial match using lower()
    @Query("Select e from Employee e where lower(e.firstName) LIKE lower(concat('%', :firstName, '%')) or lower(e.lastName) LIKE lower(concat('%', :lastName, '%'))")
    List<Employee> usingJPAQueryFindByLowerPartialName(String firstName, String lastName);

    // JPA hibernate query for exact match
    @Query("Select e from Employee e where lower(e.firstName) = lower(:firstName) and lower(e.lastName) = lower(:lastName)")
    List<Employee> usingJPAQueryFindByFirstNameAndLastName(String firstName, String lastName);
}
