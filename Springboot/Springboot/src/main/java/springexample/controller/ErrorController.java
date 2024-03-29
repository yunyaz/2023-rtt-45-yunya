package springexample.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController{

    private static final String PACKAGE_NAME = "springexample";

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest request, Exception ex) {
        String requestUrl = getRequestURL(request);
        log.warn("Error page exception happened on URL : " + requestUrl, ex);

        String stackTrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));

        ModelAndView model = new ModelAndView("error/500");

        // message is the request URL if it was an error page, otherwise it can be a message
        // from the class that calls it
        model.addObject("requestUrl", requestUrl);
        model.addObject("message", ex.getMessage());
        model.addObject("stackTrace", stackTrace);

        if (ex.getCause() != null) {
            model.addObject("rootCause", ExceptionUtils.getRootCause(ex));

            String rootTrace = getHTMLStackTrace(ExceptionUtils.getRootCauseStackTrace(ex));
            model.addObject("rootTrace", rootTrace);
        }

        return model;
    }

    private String getHTMLStackTrace(String[] stack) {
        StringBuffer result = new StringBuffer();
        for (String frame : stack) {
            if (frame.contains(PACKAGE_NAME)) {
                result.append(" &nbsp; &nbsp; &nbsp;" + frame.trim().substring(3) + "<br>\n");
            } else if (frame.contains("Caused by:")) {
                result.append("Caused By:<br>");
            }
        }

        return result.toString();
    }

    public String getRequestURL(HttpServletRequest request) {
        String result = request.getRequestURL().toString();
        if (request.getQueryString() != null) {
            result = result + "?" + request.getQueryString();
        }

        return result;
    }



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
