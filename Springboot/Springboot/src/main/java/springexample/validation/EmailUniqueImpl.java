package springexample.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import springexample.database.dao.EmployeeDAO;
import springexample.database.dao.UserDAO;
import springexample.database.entity.Employee;
import springexample.database.entity.User;

@Slf4j
public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

//        Employee employee = employeeDao.findByEmail(value);

//        return (employee == null);

        boolean valid = existsExample2(value);

        log.debug("Email " + value + " exists = " + valid);

        // we want this validation to return true if the email is NOT in the database

        return valid;
    }

    public boolean existsExample2(String value) {
        // in this method we have used a spring data jpa function to see if the email exists
        boolean exists = employeeDao.existsByEmail(value);
        return !exists;
    }

    public boolean existsExample1(String value) {
        // if a record returns it means they exist in the database
        // if null then the user does not exist

        Employee employee = employeeDao.findByEmail(value);

        // if the result is true then the validation passes
        // so if the user returned from the query is null then we pass the validation
        return (employee == null);
    }

}