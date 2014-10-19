package com.around.dev.exception;

/**
 * Created by laurent on 26/07/2014.
 */
public class AuthenticateUserException extends Exception{
    private String type = "default";
    private String message;

    public AuthenticateUserException(String type, String message){
        super(message);
        this.type = type;
        this.message = message;
    }

    public AuthenticateUserException(String message){
        super(message);
        this.type = "default";
        this.message = message;
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
