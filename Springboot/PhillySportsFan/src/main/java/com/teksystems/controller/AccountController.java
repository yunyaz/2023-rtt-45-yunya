package com.teksystems.controller;

import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.dao.UserRoleDAO;
import com.teksystems.database.entity.User;
import com.teksystems.database.entity.UserRole;
import com.teksystems.formbeans.ChangeEmailFormBean;
import com.teksystems.formbeans.ChangePasswordFormBean;
import com.teksystems.formbeans.CreateUserFormBean;
import com.teksystems.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/createAccount")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("account/createAccount");
        log.debug("In the account controller - create account");
        return response;
    }

    @PostMapping("/createAccountSubmit")
    public ModelAndView createAccountSubmit(@Valid CreateUserFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("account/createAccount");
        log.debug("In the account controller - create account submit");

        response.addObject("form", form);

        if (StringUtils.equals(form.getPassword(), form.getConfirmPassword()) == false){
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
        }

        if (bindingResult.hasErrors() ) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field : " + error.getField() + " with message : " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            return response;
        }

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        if (form.getSubscription() == null) {
            user.setSubscription(false);
        } else {
            user.setSubscription(true);
        }

        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        userDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());

        userRoleDao.save(userRole);

        authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());

        response.addObject("success", true);

        return response;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView("account/login");
        log.debug("In the account controller - login");
        return response;
    }

    @GetMapping("/myAccount")
    public ModelAndView detail() {
        ModelAndView response = new ModelAndView("account/myAccount/accountDetail");
        log.debug("In the account controller - account detail");
        return response;
    }

    @GetMapping("/myAccount/changeEmail")
    public ModelAndView changeEmail() {
        ModelAndView response = new ModelAndView("account/myAccount/changeEmail");
        return response;
    }

    @PostMapping("/myAccount/changeEmailSubmit")
    public ModelAndView changeEmailSubmit(@Valid ChangeEmailFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("account/myAccount/changeEmail");
        log.debug("In the account controller - change email");

        response.addObject("form", form);

        User user = authenticatedUserService.loadCurrentUser();

        if (StringUtils.equals(form.getEmail(), form.getConfirmEmail()) == false){
            bindingResult.rejectValue("confirmEmail", "error.confirmEmail", "Email addresses do not match");
        }

        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            bindingResult.rejectValue("password", "error.password", "Invalid password");
        }

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field : " + error.getField() + " with message : " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            return response;
        }

        user.setEmail(form.getEmail());
        userDao.save(user);

        authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());

        response.addObject("success", true);


        return response;
    }

    @GetMapping("/myAccount/changePassword")
    public ModelAndView changePassword() {
        ModelAndView response = new ModelAndView("account/myAccount/changePassword");
        return response;
    }

    @PostMapping("/myAccount/changePasswordSubmit")
    public ModelAndView changePasswordSubmit(@Valid ChangePasswordFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("account/myAccount/changePassword");
        log.debug("In the account controller - change password");

        response.addObject("form", form);

        User user = authenticatedUserService.loadCurrentUser();

        if (!passwordEncoder.matches(form.getCurrentPassword(), user.getPassword())) {
            bindingResult.rejectValue("currentPassword", "error.currentPassword", "Invalid current password");
        }

        if (StringUtils.equals(form.getNewPassword(), form.getConfirmNewPassword()) == false){
            bindingResult.rejectValue("confirmNewPassword", "error.confirmNewPassword", "New passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field : " + error.getField() + " with message : " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            return response;
        }

        String encryptedNewPassword = passwordEncoder.encode(form.getNewPassword());
        user.setPassword(encryptedNewPassword);
        userDao.save(user);

        authenticatedUserService.changeLoggedInUsername(session, user.getEmail(), form.getNewPassword());

        response.addObject("success", true);

        return response;
    }

    @GetMapping("message")
    public ModelAndView messageAlert() {
        return new ModelAndView("account/message");
    }
}
