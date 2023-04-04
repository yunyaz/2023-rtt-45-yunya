package com.teksystems.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SlashController {

    @GetMapping({"/index,", "/", "/index.html"})
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        return response;
    }
}
