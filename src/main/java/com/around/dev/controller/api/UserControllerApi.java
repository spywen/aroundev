package com.around.dev.controller.api;

import com.around.dev.business.UserBusiness;
import com.around.dev.entity.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by laurent on 21/07/2014.
 */
@Controller
@RequestMapping("/api/user")
public class UserControllerApi {
    private static final Logger logger = Logger.getLogger(UserControllerApi.class);
    @Autowired
    UserBusiness userBusiness;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserEntity> getUsers() {
        return userBusiness.findAll();
    }
}
