package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserFormBean {

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;

    private Boolean subscription;
}
