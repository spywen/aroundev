package com.around.dev.business;

import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by laurent on 19/07/2014.
 */
@Component
public class UserBusiness {
    @Autowired
    public UserRepository userRepository;
    /**
     * Get
     */
    public long countUserById(int id){
        return userRepository.countById(id);
    }

    /**
     * Get the connected user profile
     * @return
     * @throws com.around.dev.exception.User.UserNotFoundException
     */
    public UserAroundev getConnectedUser() throws UserNotFoundException {
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();
            return userRepository.findByLogin(name);
        }
        throw new UserNotFoundException();
    }
}
