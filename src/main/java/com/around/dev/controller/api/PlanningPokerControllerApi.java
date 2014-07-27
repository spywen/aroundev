package com.around.dev.controller.api;

import com.around.dev.business.PlanningPokerBusiness;
import com.around.dev.entity.planningpoker.Grooming;
import com.around.dev.entity.planningpoker.StoryStatus;
import com.around.dev.exception.AuthenticateUserException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by laurent on 27/07/2014.
 */
@Controller
@RequestMapping("/api/planningpoker")
public class PlanningPokerControllerApi {
    private static final Logger logger = Logger.getLogger(PlanningPokerControllerApi.class);
    @Autowired
    PlanningPokerBusiness planningPokerBusiness;

    @RequestMapping(method = RequestMethod.GET, value = "/grooming", produces = "application/json")
    @ResponseBody
    public List<Grooming> getGroomings() throws AuthenticateUserException {
        return planningPokerBusiness.getGroomingsByUser();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/storystatus", produces = "application/json")
    @ResponseBody
    public List<StoryStatus> getStoryStatus() {
        return planningPokerBusiness.getStoryStatus();
    }
}
