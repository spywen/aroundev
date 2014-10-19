package com.around.dev.controller.exception;

import com.around.dev.exception.AuthenticateUserException;
import com.around.dev.exception.ExceptionInfo;
import com.around.dev.exception.RightException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by laurent on 26/07/2014.
 */
@ControllerAdvice
public class AdviceController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticateUserException.class)
    @ResponseBody
    public ExceptionInfo AuthenticateUserException(AuthenticateUserException ex) {
        return new ExceptionInfo(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RightException.class)
    @ResponseBody
    public ExceptionInfo RightException(RightException ex) {
        return new ExceptionInfo(ex);
    }
}
