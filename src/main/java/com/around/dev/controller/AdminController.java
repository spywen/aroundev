package com.around.dev.controller;

import com.around.dev.business.UserBusiness;
import com.around.dev.exception.AuthenticateUserException;
import com.around.dev.utils.GroupRoles;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by laurent on 26/07/2014.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(GController.class);
    @Autowired
    UserBusiness userBusiness;

    @PreAuthorize("hasAnyRole('"+ GroupRoles.ADMIN+"')")
    @RequestMapping(method = RequestMethod.GET, value = "tests")
    public ModelAndView angularTestsPage() throws AuthenticateUserException {
        logger.info("Someone acceed to the admin 'angularTests' page. User id = " + userBusiness.getConnectedUser().getId());
        ModelAndView modelAndView = new ModelAndView("admin/angularTests");
        return modelAndView;
    }
}
