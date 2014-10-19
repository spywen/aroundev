package com.around.dev.exception;

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
    public  ExceptionInfo(AuthenticateUserException e){
        this.message = e.getMessage();
        this.type = e.getType();
    }

    //Right required
    public  ExceptionInfo(RightException e){
        this.message = e.getMessage();
        this.type = e.getType();
    }
}
