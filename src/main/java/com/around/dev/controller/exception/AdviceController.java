package com.around.dev.controller.exception;

import com.around.dev.exception.ExceptionInfo;
import com.around.dev.exception.User.RightException;
import com.around.dev.exception.User.UserNotFoundException;
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
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ExceptionInfo AuthenticateUserException(UserNotFoundException ex) {
        return new ExceptionInfo(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RightException.class)
    @ResponseBody
    public ExceptionInfo RightException(RightException ex) {
        return new ExceptionInfo(ex);
    }
}
