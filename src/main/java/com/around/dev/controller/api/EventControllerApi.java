package com.around.dev.controller.api;

import com.around.dev.business.EventBusiness;
import com.around.dev.entity.eventmanager.Event;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.utils.enums.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by laurent on 10/11/14.
 */
@Controller
@RequestMapping("/api/events")
public class EventControllerApi {

    @Autowired
    EventBusiness eventBusiness;

    /**
     * Save a new event
     * @param event
     * @return
     */
    @PreAuthorize("hasAnyRole('"+ EnumRole.SUPINFO_NICE +","+ EnumRole.ADMIN +"')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public int save(@RequestBody @Valid Event event) throws UserNotFoundException {
        Event eventSaved = eventBusiness.save(event);
        return eventSaved.getId();
    }

    @PreAuthorize("hasAnyRole('"+ EnumRole.SUPINFO_NICE +","+ EnumRole.ADMIN +"')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> findAll(){
        return eventBusiness.findAll();
    }

}
