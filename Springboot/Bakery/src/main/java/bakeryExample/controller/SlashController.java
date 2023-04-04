package bakeryExample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SlashController {

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @RequestMapping(value="/cake", method=RequestMethod.GET)
    public ModelAndView cake() {
        ModelAndView response = new ModelAndView("cake");
        return response;
    }

    @RequestMapping(value="/customOrder", method=RequestMethod.GET)
    public ModelAndView customOrder() {
        ModelAndView response = new ModelAndView("customOrder");
        return response;
    }
}
