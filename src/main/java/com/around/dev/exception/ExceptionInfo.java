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

    //Inscription
    /*public  ExceptionInfo(InscriptionException uploadException){
        this.message = uploadException.getMessage();
        this.type = uploadException.getType();
    }*/
}
