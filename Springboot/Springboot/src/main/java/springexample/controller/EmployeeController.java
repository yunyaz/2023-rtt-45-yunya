package springexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexample.database.dao.EmployeeDAO;
import springexample.database.entity.Employee;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping(value="/employee_search", method= RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, String lastName) {
        log.info("In the employee search controller method with search = " + firstName + lastName);
        ModelAndView response = new ModelAndView("employee/employee_search");

        // List<Employee> employees = employeeDao.getAllEmployees();
        // response.addObject("employeesList", employees);

        /*
        // List<Employee> employees = employeeDao.findByFirstName(search);
        // List<Employee> employees = employeeDao.findByFirstNameIgnoreCase(search);
        List<Employee> employees = employeeDao.findByFirstNameOrLastNameIgnoreCase(search, search);
        response.addObject("employeesList", employees);
         */

        // JPA query using built-in function
//        List<Employee> employees = employeeDao.findByFirstNameContainingOrLastNameContainingIgnoreCase(search, search);

        // native query
//        List<Employee> employees = employeeDao.usingNativeQueryFindByFirstNameOrLastName(search, search);

        // JPA query
//        List<Employee> employees = employeeDao.usingJPAQueryFindByFirstNameOrLastName(search, search);

        // JPA query using LIKE for partial match
//        List<Employee> employees = employeeDao.usingJPAQueryFindByPartialName(firstName, lastName);

        // JPA query for exact match
        List<Employee> employees = employeeDao.usingJPAQueryFindByFirstNameAndLastName(firstName, lastName);
        response.addObject("employeesList", employees);
        response.addObject("searchFirst", firstName);
        response.addObject("searchLast", lastName);

        return response;
    }
}
