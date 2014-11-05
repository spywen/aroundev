package com.around.dev.controller;

/**
 * Created by laurent on 26/07/2014.
 */
/*
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(GController.class);
    @Autowired(required = true)
    UserBusiness userBusiness;

    @PreAuthorize("hasAnyRole('"+ GroupRoles.ADMIN+"')")
    @RequestMapping(method = RequestMethod.GET, value = "tests")
    public ModelAndView angularTestsPage() throws UserNotFoundException {
        logger.info("Someone acceed to the admin 'angularTests' page. user id = " + userBusiness.getConnectedUser().getId());
        ModelAndView modelAndView = new ModelAndView("admin/angularTests");
        return modelAndView;
    }
}
*/