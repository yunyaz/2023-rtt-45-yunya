package springexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping(value="/index.html", method= RequestMethod.GET)
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @RequestMapping(value="/signup.html", method= RequestMethod.GET)
    public ModelAndView signup() {
        log.info("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");
        return response;
    }
}
