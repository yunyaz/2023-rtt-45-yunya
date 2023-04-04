package springexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexample.database.dao.EmployeeDAO;
import springexample.database.dao.OfficeDAO;
import springexample.database.entity.Employee;
import springexample.database.entity.Office;
import springexample.formbeans.EmployeeFormBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private OfficeDAO officeDAO;

    // @PathVariable
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");

        log.debug("In employee detail controller method with id = " + id);
        Employee employee = employeeDao.findById(id);
        response.addObject("employee", employee);

        log.debug(employee + "");
        return response;
    }

    // @RequestParam
    @RequestMapping(value="/search", method= RequestMethod.GET)
    // firstName, lastName need to be same as shown in url, which are also same as "name" attribute in html
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        log.debug("In the employee search controller method with search = " + firstName + lastName);
        ModelAndView response = new ModelAndView("employee/search");

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
//        List<Employee> employees = employeeDao.usingJPAQueryFindByFirstNameAndLastName(firstName, lastName);

        List<Employee> employees = new ArrayList<>();


        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            employees = employeeDao.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        } else if (!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            employees = employeeDao.findByFirstNameContainingIgnoreCase(firstName);
        } else if (StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            employees = employeeDao.findByLastNameContainingIgnoreCase(lastName);
        }

        // add search parameters to models which can be shown in html search block
        response.addObject("employeesList", employees);
        response.addObject("searchFirst", firstName);
        response.addObject("searchLast", lastName);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee controller - create employee");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee controller - edit employee");

        Employee emp = employeeDao.findById(id);
        EmployeeFormBean form = new EmployeeFormBean();

        // we are setting the employee id and all other employee fields on the form object
        // so that we can pass them to the jsp through the model

        form.setId(emp.getId());

        form.setEmail(emp.getEmail());
        form.setFirstName(emp.getFirstName());
        form.setLastName(emp.getLastName());
        form.setExtension(emp.getExtension());
        form.setJobTitle(emp.getJobTitle());
        form.setVacationHours(emp.getVacationHours());
        form.setOfficeId(emp.getOfficeId());

        // add the form bean to the model to pass it to the jsp page
        response.addObject("form", form);

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(EmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        log.debug("In employee controller - create employee submit");
        log.debug(form.toString());

        // create a new database entity
        // and populating it with the incoming data from the form
        Employee emp = new Employee();

        if (form.getId() != null && form.getId() > 0) {
            emp = employeeDao.findById(form.getId());
        }

        emp.setEmail(form.getEmail());
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setExtension(form.getExtension());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        emp.setOfficeId(form.getOfficeId());

        employeeDao.save(emp);

        response.addObject("form", form);

        return response;
    }
}
