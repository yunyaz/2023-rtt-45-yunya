package com.teksystems.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/createAccount")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("account/createAccount");
        return response;
    }

    @GetMapping("/signin")
    public ModelAndView signin() {
        ModelAndView response = new ModelAndView("account/signin");
        return response;
    }
}
