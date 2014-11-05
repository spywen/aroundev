package com.around.dev.tests.user;

import com.around.dev.business.UserBusiness;
import com.around.dev.entity.Role;
import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.UserRepository;
import com.around.dev.utils.UserConnectedProfile;
import com.around.dev.utils.enums.EnumRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.*;

/**
 * Created by laurent on 20/10/2014.
 * REMARK !!! : for all testing classes finished their name by '...Tests'
 */
@RunWith(MockitoJUnitRunner.class)
public class UserBusinessTests {

    //region init testing
    @InjectMocks UserBusiness userBusiness;
    @Mock UserRepository userRepository;
    static UserAroundev admin = new UserAroundev();
    @Rule public ExpectedException thrown = ExpectedException.none();


    @Before
    public void onSetUp() {
        //Mock authentification
        List<GrantedAuthority> adminAuthorities=new ArrayList<GrantedAuthority>(2);
        adminAuthorities.add(new SimpleGrantedAuthority(EnumRole.USER));
        adminAuthorities.add(new SimpleGrantedAuthority(EnumRole.ADMIN));
        User adminSpringUser = new User("admin","cisco", adminAuthorities);

        Authentication auth = new UsernamePasswordAuthenticationToken(adminSpringUser,null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        admin.setId(1);
        admin.setFirstname("admin");
        admin.setEmail("admin@admin.com");
        admin.setIsactive(true);
        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setName(EnumRole.ADMIN);
        Role userRole = new Role();
        userRole.setId(2);
        userRole.setName(EnumRole.USER);
        Set<Role> roles = new HashSet<Role>(Arrays.asList(adminRole, userRole));
        admin.setRoles(roles);

        //Init injection
        MockitoAnnotations.initMocks(this);
    }
    //endregion

    //region Repository findByLogin
    @Test
    public void findByLogin() throws UserNotFoundException {
        UserAroundev lolo = new UserAroundev();
        lolo.setFirstname("lolo");
        Mockito.when(userRepository.findByLogin("lolo")).thenReturn(lolo);

        UserAroundev userReturned = userRepository.findByLogin("lolo");
        Assert.assertSame(userReturned.getFirstname(), lolo.getFirstname());
    }
    //endregion

    //region getConnectedUser
    @Test
    public void getConnectectedUser_throughServiceSecurityContext(){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Assert.assertSame(user.getUsername(), "admin");
    }

    @Test
    public void getConnectedUser_NominalCase() throws UserNotFoundException {
        Mockito.when(userRepository.findByLogin("admin")).thenReturn(admin);

        UserAroundev userReturned = userBusiness.getConnectedUser();
        Assert.assertSame(userReturned, admin);
        Assert.assertSame(admin.getFirstname(), userReturned.getFirstname());
        //Roles
        Assert.assertNotNull(userReturned.getRoles());
        Assert.assertSame(userReturned.getRoles().size(), 2);
    }

    @Test(expected=UserNotFoundException.class)
    public void getConnectedUser_notConnected() throws UserNotFoundException {
        //Remove connected user
        SecurityContextHolder.getContext().setAuthentication(null);

        userBusiness.getConnectedUser();
    }
    //endregion

    //region getUserConnectedProfile
    @Test
    public void getUserConnectedProfile_NotConnected(){
        SecurityContextHolder.getContext().setAuthentication(null);

        UserConnectedProfile userConnectedProfile = userBusiness.getUserConnectedProfile();
        Assert.assertSame("", userConnectedProfile.getUsername());
        Assert.assertSame(0, userConnectedProfile.getRoles().size());
    }

    @Test
    public void getUserConnectedProfile_Connected(){
        Mockito.when(userRepository.findByLogin("admin")).thenReturn(admin);

        UserConnectedProfile userConnectedProfile = userBusiness.getUserConnectedProfile();
        Assert.assertSame(admin.getLogin(), userConnectedProfile.getUsername());
        Assert.assertSame(admin.getRoles().size(), userConnectedProfile.getRoles().size());
    }
    //endregion

}
