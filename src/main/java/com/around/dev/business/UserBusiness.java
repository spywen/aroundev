package com.around.dev.business;

import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.AuthenticateUserException;
import com.around.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * Find all
     * @return
     */
    public List<UserAroundev> findAll() { return userRepository.findAll(); }

    /**
     * Get the connected user profile
     * @return
     * @throws AuthenticateUserException
     */
    public UserAroundev getConnectedUser() throws AuthenticateUserException {
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();
            return userRepository.findByLogin(name);
        }
        throw new AuthenticateUserException("USER_NOT_CONNECTED", "User not connected.");
    }
}
