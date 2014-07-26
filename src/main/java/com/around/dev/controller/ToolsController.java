package com.around.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by laurent on 26/07/2014.
 */
@Controller
@RequestMapping("/tools")
public class ToolsController {

    @RequestMapping(method = RequestMethod.GET, value = "planningpoker")
    public ModelAndView planningPokerPage() {
        ModelAndView modelAndView = new ModelAndView("tools/planningPoker");
        return modelAndView;
    }
}
