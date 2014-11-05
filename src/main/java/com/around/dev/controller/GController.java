package com.around.dev.controller;

import com.around.dev.business.UserBusiness;
import com.around.dev.utils.UserConnectedProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by laurent on 06/07/2014.
 */
@Controller
@RequestMapping("/")
public class GController {
    private static final Logger logger = Logger.getLogger(GController.class);

    @Autowired
    public UserBusiness userBusiness;

    @RequestMapping(method = RequestMethod.GET, value = "*")
    public ModelAndView SingleApplicationPage() {
        ModelAndView modelAndView = new ModelAndView("index");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter();

        UserConnectedProfile userConnected = userBusiness.getUserConnectedProfile();

        String userConnectedStringified = null;
        try {
            userConnectedStringified = objectMapper.writeValueAsString(userConnected);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("userConnected", userConnectedStringified);
        return modelAndView;
    }

}
