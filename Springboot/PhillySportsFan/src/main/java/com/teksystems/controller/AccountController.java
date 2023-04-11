package com.teksystems.controller;

import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.dao.UserRoleDAO;
import com.teksystems.database.entity.User;
import com.teksystems.database.entity.UserRole;
import com.teksystems.formbeans.CreateUserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/createAccount")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("account/createAccount");
        log.debug("In the account controller - create account");
        return response;
    }

    @PostMapping("/createAccountSubmit")
    public ModelAndView createAccountSubmit(CreateUserFormBean form) {
        ModelAndView response = new ModelAndView("account/createAccount");
        log.debug("In the account controller - create account submit");

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setSubscription(form.getSubscription());

        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        userDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());

        userRoleDao.save(userRole);

        return response;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView("account/login");
        log.debug("In the account controller - login");
        return response;
    }
}
