package com.around.dev.exception;

/**
 * Created by laurent on 28/07/2014.
 */
public class RightException extends Exception {
    private String type = "default";
    private String message;

    public RightException(String type, String message){
        super(message);
        this.type = type;
        this.message = message;
    }

    public RightException(String message){
        super(message);
        this.type = "default";
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
