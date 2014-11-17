package com.around.dev.business;

import com.around.dev.entity.eventmanager.Event;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by laurent on 10/11/14.
 */
@Component
public class EventBusiness {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserBusiness userBusiness;

    /**
     * Create a new event
     * @param event
     * @return
     * @throws UserNotFoundException
     */
    public Event save(Event event) throws UserNotFoundException {
        event.setCreationdate(new Timestamp(new Date().getTime()));
        event.setOwner(userBusiness.getConnectedUser());
        eventRepository.save(event);
        return event;
    }

    /**
     * Get all events
     * @return
     */
    public List<Event> findAll(){
        return eventRepository.findAll(new Sort(Sort.Direction.DESC, "creationdate"));
    }
}
