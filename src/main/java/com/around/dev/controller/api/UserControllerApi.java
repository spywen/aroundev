package com.around.dev.controller.api;

import com.around.dev.business.UserBusiness;
import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by laurent on 21/07/2014.
 */
@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
    private static final Logger logger = Logger.getLogger(UserControllerApi.class);
    @Autowired
    UserBusiness userBusiness;

    @RequestMapping(value = "/currentProfil",method = RequestMethod.GET)
    public UserAroundev getUserProfil() throws UserNotFoundException {
        return userBusiness.getConnectedUser();
    }
}
