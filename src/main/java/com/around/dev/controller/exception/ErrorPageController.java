package com.around.dev.controller.exception;

import com.google.common.base.Throwables;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * Created by laurent on 19/10/2014.
 */
@Controller
public class ErrorPageController {
    private static final Logger logger = Logger.getLogger(ErrorPageController.class);

    @RequestMapping("error")
    public ModelAndView customError(HttpServletRequest request, HttpServletResponse response) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String exceptionMessage = getExceptionMessage(throwable, statusCode);

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        String message = MessageFormat.format("{0} returned for {1} with message {2}",
                statusCode, requestUri, exceptionMessage
        );

        //Log
        logger.error("Error page : " + message, new Exception(message));

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("code", statusCode);
        modelAndView.addObject("message", exceptionMessage);
        modelAndView.addObject("errorMessage", message);
        return modelAndView;
    }

    private String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (throwable != null) {
            return Throwables.getRootCause(throwable).getMessage();
        }
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        return httpStatus.getReasonPhrase();
    }
}

