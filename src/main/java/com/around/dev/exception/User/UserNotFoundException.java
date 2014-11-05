package com.around.dev.exception.User;

import com.around.dev.exception.BaseException;

/**
 * Created by laurent on 22/10/14.
 */
public class UserNotFoundException extends BaseException{

    public UserNotFoundException(String type, String message) {
        super(type, message);
    }
}