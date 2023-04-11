package springexample.formbeans;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import springexample.validation.EmailUnique;

@Getter
@Setter
@ToString
public class EmployeeFormBean {

    private Integer id;

    @NotEmpty(message = "Email address is required.")
    @Length(max = 30, message = "Email can not be longer than 20 characters.")
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid email format")
    @EmailUnique(message = "Email already exists in database")
    private String email;

    @Length(max = 40, message = "First name can not be longer than 40 characters.")
    @NotEmpty(message = "First name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    private String jobTitle;

    @Max(value = 100, message = "You can not have more than 100 vacation hours.")
    @Min(value = 0, message = "You can not have less than 0 vacation hours.")
    private Integer vacationHours;

    private String extension;

    private Integer officeId;

    private String profileImageUrl;
}
