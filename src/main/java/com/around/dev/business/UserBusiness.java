package com.around.dev.business;

import com.around.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by laurent on 19/07/2014.
 */
@Component
public class UserBusiness {
    @Autowired
    UserRepository userRepository;
    /**
     * Get
     */
    public long countUserById(int id){
        return userRepository.countById(id);
    }
}
