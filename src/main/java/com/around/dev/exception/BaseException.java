package com.around.dev.exception;

/**
 * Created by laurent on 22/10/14.
 */
public class BaseException extends Exception {
    private String type = "default";
    private String message;

    public BaseException() { super(); }

    public BaseException(String type, String message){
        super(message);
        this.type = type;
        this.message = message;
    }

    public BaseException(String message){
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
