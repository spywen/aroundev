package com.around.dev.business;

import com.around.dev.entity.Role;
import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.RoleRepository;
import com.around.dev.repository.UserRepository;
import com.around.dev.security.UserSubscriptionInformations;
import com.around.dev.utils.UserConnectedProfile;
import com.around.dev.utils.enums.EnumRole;
import com.around.dev.utils.facades.EmailFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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
     * @param newUser
     * @return
     */
    public int signIn(UserSubscriptionInformations newUser){
        Role userRole = roleRepository.findByName(EnumRole.USER);
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);

        UserAroundev user = new UserAroundev()
                .setLogin(newUser.getLogin())
                .setEmail(newUser.getEmail())
                .setFirstname(newUser.getFirstname())
                .setLastname(newUser.getLastname())
                .setIsfemale(newUser.getIsfemale())
                .setPassword(encoder.encodePassword(newUser.getPassword(), null))
                .setIsactive(true)
                .setRegisterdate(new Timestamp(new Date().getTime()))
                .setSupinfoid(newUser.getSupinfoId());
        user = userRepository.saveAndFlush(user);

        //Attribute role
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

        return user.getId();
    }

    /**
     * Define if the a supinfo id is already registered
     * @param supinfoId
     * @return
     */
    public Boolean existSupinfoId(int supinfoId){
        if(userRepository.countBySupinfoid(supinfoId) == 0){
            return false;
        }
        return true;
    }

    /**
     * Define if the an email is already registered
     * @param email
     * @return
     */
    public Boolean existEmail(EmailFacade email){
        if(userRepository.countByEmail(email.getEmail()) == 0){
            return false;
        }
        return true;
    }

    /**
     * Define if the a login is already registered
     * @param login
     * @return
     */
    public Boolean existLogin(String login){
        if(userRepository.countByLogin(login) == 0){
            return false;
        }
        return true;
    }
}
