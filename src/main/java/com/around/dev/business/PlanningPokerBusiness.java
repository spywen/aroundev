package com.around.dev.business;

import com.around.dev.entity.planningpoker.Grooming;
import com.around.dev.entity.planningpoker.StoryStatus;
import com.around.dev.exception.AuthenticateUserException;
import com.around.dev.repository.planningPoker.GroomingRepository;
import com.around.dev.repository.planningPoker.StoryRepository;
import com.around.dev.repository.planningPoker.StoryStatusRepository;
import com.around.dev.repository.planningPoker.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<Grooming> getGroomingsByUser() throws AuthenticateUserException {
        return groomingRepository.findAllByModerator(userBusiness.getConnectedUser().getId());
    }

    public List<StoryStatus> getStoryStatus(){
        return storyStatusRepository.findAll();
    }
}
