package com.around.dev.controller;

import com.around.dev.business.UserBusiness;
import com.around.dev.utils.UserConnectedProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by laurent on 06/07/2014.
 */
@Controller
@RequestMapping("/")
public class GController {
    private static final Logger logger = Logger.getLogger(GController.class);

    private static final String FRONT_END_CONFIGS_DEFAULTLANGUAGE = "front.end.configs.defaultLanguage";
    private static final String FRONT_END_CONFIGS_TRANSLATEALLOWED = "front.end.configs.translateAllowed";

    @Autowired
    public UserBusiness userBusiness;

    @Resource
    Environment environment;

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
        modelAndView.addObject("defaultLanguage",environment.getRequiredProperty(FRONT_END_CONFIGS_DEFAULTLANGUAGE));
        modelAndView.addObject("translateAllowed",environment.getRequiredProperty(FRONT_END_CONFIGS_TRANSLATEALLOWED));
        return modelAndView;
    }

}
