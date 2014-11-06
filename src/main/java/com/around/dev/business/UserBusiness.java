package com.around.dev.business;

import com.around.dev.entity.Role;
import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.RoleRepository;
import com.around.dev.repository.UserRepository;
import com.around.dev.security.UserSubscriptionInformations;
import com.around.dev.utils.UserConnectedProfile;
import com.around.dev.utils.enums.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by laurent on 19/07/2014.
 */
@Component
public class UserBusiness {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    /**
     * Get complete the connected user profile
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

    /**
     * Get partial user profile : Username (login) and roles
     * @return
     */
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

    /**
     * Sign in method
     * @return
     */
    public int signIn(UserSubscriptionInformations newUser){
        Role userRole = roleRepository.findByName(EnumRole.USER);

        UserAroundev user = new UserAroundev()
                .setLogin(newUser.getLogin())
                .setEmail(newUser.getEmail())
                .setFirstname(newUser.getFirstname())
                .setLastname(newUser.getLastname())
                .setIsfemale(newUser.getIsfemale())
                .setPassword(newUser.getPassword())
                .setIsactive(true)
                .setRegisterdate(new Timestamp(new Date().getTime()))
                .setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        user = userRepository.saveAndFlush(user);
        return user.getId();
    }
}
