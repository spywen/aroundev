package com.around.dev.controller;

import com.around.dev.business.UserBusiness;
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
    UserBusiness userBusiness;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePage() {
        //logger.info("Ouverture de la page principale..");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("test",userBusiness.countUserById(2));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}
