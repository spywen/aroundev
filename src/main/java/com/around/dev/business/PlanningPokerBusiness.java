package com.around.dev.business;

import com.around.dev.entity.planningpoker.Grooming;
import com.around.dev.entity.planningpoker.StoryStatus;
import com.around.dev.exception.User.RightException;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.planningPoker.GroomingRepository;
import com.around.dev.repository.planningPoker.StoryRepository;
import com.around.dev.repository.planningPoker.StoryStatusRepository;
import com.around.dev.repository.planningPoker.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by laurent on 27/07/2014.
 */
@Component
public class PlanningPokerBusiness {
    @Autowired
    UserBusiness userBusiness;
    @Autowired
    GroomingRepository groomingRepository;
    @Autowired
    StoryRepository storyRepository;
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    StoryStatusRepository storyStatusRepository;

    public List<Grooming> getGroomingsByUser() throws UserNotFoundException {
        return groomingRepository.findAllByModerator(userBusiness.getConnectedUser().getId());
    }

    public List<StoryStatus> getStoryStatus(){
        return storyStatusRepository.findAll();
    }

    public void save(Grooming grooming) throws UserNotFoundException {
        grooming.setCreationdate(new Timestamp(new Date().getTime()));
        grooming.setModerator(userBusiness.getConnectedUser().getId());
        groomingRepository.save(grooming);
    }

    public void delete(int id) throws UserNotFoundException, RightException {
        Grooming grooming = groomingRepository.findOne(id);
        if(grooming != null){
            if(grooming.getModerator()!=userBusiness.getConnectedUser().getId())
                throw new RightException();
            groomingRepository.delete(grooming);
        }
    }
}
