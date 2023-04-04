package springexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SlashController {

    @RequestMapping(value={"/index", "/", "/index.html"}, method=RequestMethod.GET)
    public ModelAndView index() {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        log.debug("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");
        return response;
    }

    @RequestMapping(value="/bootstrap", method= RequestMethod.GET)
    public ModelAndView bootstrap() {
        log.debug("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");
        return response;
    }
}
