package springexample.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexample.database.dao.UserDAO;
import springexample.database.dao.UserRoleDAO;
import springexample.database.entity.User;
import springexample.database.entity.UserRole;
import springexample.formbeans.CreateUserFormBean;
import springexample.security.AuthenticatedUserService;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @RequestMapping(value={"/index", "/", "/index.html"}, method=RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");

        log.debug("######### Session attribute name = "
                + session.getAttribute("name"));

        return response;
    }

    @GetMapping("/signup")
    public ModelAndView signup(HttpSession session) {
        log.debug("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");
        session.setAttribute("name", "signup set this value");
        return response;
    }


    @PostMapping("/signup")
    public ModelAndView signup(@Valid CreateUserFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller post method");
        log.debug(form.toString());

        response.addObject("form", form);

        if (StringUtils.equals(form.getPassword(), form.getConfirmPassword()) == false){
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
        }

        if(bindingResult.hasErrors()){
            for ( FieldError error : bindingResult.getFieldErrors()){
                log.debug("Validation Error on field: " + error.getField());

                log.debug("Validation Error Message: " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            return response;
        }

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFullName(form.getFullName());

        // this is needed by Spring security to encrypt passwords as the user is being created
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        // save our user .. when hibernate saves this user it will auto generate the Id
        // and it will populate the field in the user entity
        userDao.save(user);

        // create our user role object
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        // so when we go to set the user id FK on the user role entity the user id has been populated already
        userRole.setUserId(user.getId());

        userRoleDao.save(userRole);

        authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());

        return response;
    }

    @RequestMapping(value="/bootstrap", method= RequestMethod.GET)
    public ModelAndView bootstrap(HttpSession session) {
        log.debug("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");
        session.setAttribute("name", "bootstrap set this value");
        return response;
    }


}
