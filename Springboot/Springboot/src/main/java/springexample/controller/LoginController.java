package springexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login/loginPage")
    public ModelAndView setup() {
        log.debug("In the login controller method");
        ModelAndView response = new ModelAndView("login/login");

        return response;
    }

}
