package com.teksystems.formbeans;

import com.teksystems.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CheckoutFormBean {

    @NotEmpty(message = "First name is required.")
    @Length(max = 40, message = "First name can not be longer than 40 characters.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @NotEmpty(message = "Address is required")
    @Length(max = 100, message = "Address can not be longer than 100 characters in one line. Otherwise, please use two lines")
    private String addressLine1;

    private String addressLine2;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "State is required")
    private String state;

    @NotEmpty(message = "Zipcode is required")
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Invalid email format")
    private String zipcode;

    @NotEmpty(message = "Credit card number is required")
    @Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})? | (?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]" +
            "|2720)[0-9]{12} | 3[47][0-9]{13} | 6(?:011|5[0-9]{2})[0-9]{12})$", message = "Invalid credit card")
    private String creditCardNumber;

    @NotEmpty(message = "Expiration date is required")
    @Pattern(regexp = "^[0-9]{4}$", message = "Invalid expiration date")
    private String expirationDate;

    @NotEmpty(message = "Security code is required")
    @Pattern(regexp = "^[0-9]{3}|[0-9]{4}$", message = "Invalid security code")
    private String securityCode;

    @NotEmpty(message = "Credit card name is required")
    private String creditCardName;
}
