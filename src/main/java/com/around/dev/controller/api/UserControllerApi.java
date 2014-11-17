package com.around.dev.controller.api;

import com.around.dev.business.UserBusiness;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.security.UserSubscriptionInformations;
import com.around.dev.utils.UserConnectedProfile;
import com.around.dev.utils.facades.EmailFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public UserConnectedProfile getUserProfil() throws UserNotFoundException {
        return userBusiness.getUserConnectedProfile();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int signin(@RequestBody @Valid UserSubscriptionInformations newUser){
        return userBusiness.signIn(newUser);
    }

    @RequestMapping(value = "/exist/login/{login}", method = RequestMethod.GET)
    public Boolean existLogin(@PathVariable String login){
        return userBusiness.existLogin(login);
    }

    @RequestMapping(value = "/exist/email", method = RequestMethod.POST)
    public Boolean existSupinfoId(@RequestBody EmailFacade email){
        return userBusiness.existEmail(email);
    }

    @RequestMapping(value = "/exist/supinfoId/{supinfoId}", method = RequestMethod.GET)
    public Boolean existSupinfoId(@PathVariable int supinfoId){
        return userBusiness.existSupinfoId(supinfoId);
    }
}
