package bakeryExample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AccountController {

    @RequestMapping(value="/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        ModelAndView response = new ModelAndView("account/signin");
        return response;
    }

    @RequestMapping(value="/createAccount", method = RequestMethod.GET)
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("account/createAccount");
        return response;
    }
}
