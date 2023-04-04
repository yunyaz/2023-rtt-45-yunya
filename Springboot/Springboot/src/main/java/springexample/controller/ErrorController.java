package springexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController{

    









//    @RequestMapping(value = "/error/404")
//    public String error404(HttpServletRequest request) {
//
//        String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
//        log.info("Requested URL not found : " + request.getMethod() + " " + originalUri);
//
//        return "error/404";
//    }

//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
//
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//
//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                log.info("Requested URL not found : " + request.getMethod() + " " + originalUri);
//                return "error/404";
//            }
//            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                log.info("Requested URL not found : " + request.getMethod() + " " + originalUri);
//                return "error/500";
//            }
//        }
//        return "error";
//    }
}
