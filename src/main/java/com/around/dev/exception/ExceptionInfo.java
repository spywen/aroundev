package com.around.dev.exception;

import com.around.dev.exception.User.RightException;
import com.around.dev.exception.User.UserNotFoundException;

/**
 * Created by laurent on 26/07/2014.
 */
public class ExceptionInfo {
    private  String message;
    private String type = "default";

    public ExceptionInfo() {}

    public ExceptionInfo(String message) {
        this.message = message;
    }

    public ExceptionInfo(String message, String niveau) {
        this.message = message;
        this.type = niveau;
    }

    //Authentification required
    public  ExceptionInfo(UserNotFoundException e){
        this.message = e.getMessage();
        this.type = e.getType();
    }

    //Right required
    public  ExceptionInfo(RightException e){
        this.message = e.getMessage();
        this.type = e.getType();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
