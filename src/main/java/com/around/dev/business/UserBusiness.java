package com.around.dev.business;

import com.around.dev.entity.Role;
import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.UserRepository;
import com.around.dev.utils.UserConnectedProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laurent on 19/07/2014.
 */
@Component
public class UserBusiness {
    @Autowired
    public UserRepository userRepository;
    /**
     * Get the connected user profile
     * @return
     * @throws com.around.dev.exception.User.UserNotFoundException
     */
    public UserAroundev getConnectedUser() throws UserNotFoundException {
        if (SecurityContextHolder.getContext() != null &&
                SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            try{
                User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String name = user.getUsername();
                return userRepository.findByLogin(name);
            }catch (Exception e){
                throw new UserNotFoundException("NotConnected","user not connected");
            }
        }
        throw new UserNotFoundException("NotConnected","user not connected");
    }

    public UserConnectedProfile getUserConnectedProfile(){
        List<String> roles = new ArrayList<String>();
        try{
            UserAroundev connectedUserProfile = getConnectedUser();
            for(Role role : connectedUserProfile.getRoles()){
                roles.add(role.getName());
            }
            return new UserConnectedProfile(connectedUserProfile.getLogin(),roles);
        }catch (UserNotFoundException e){
            return new UserConnectedProfile("",new ArrayList<String>());
        }catch (Exception e){
            return new UserConnectedProfile("",new ArrayList<String>());
        }
    }
}
