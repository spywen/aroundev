package com.around.dev.tests;

import com.around.dev.business.UserBusiness;
import com.around.dev.entity.UserAroundev;
import com.around.dev.exception.User.UserNotFoundException;
import com.around.dev.repository.UserRepository;
import com.around.dev.utils.enums.EnumRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laurent on 20/10/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserBusinessTests {
    @InjectMocks public UserBusiness userBusiness;

    @Mock UserRepository userRepository;

    static UserAroundev admin = new UserAroundev();

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

        //Init injection
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByLogin_Test() throws UserNotFoundException {
        UserAroundev lolo = new UserAroundev();
        lolo.setFirstname("lolo");
        Mockito.when(userRepository.findByLogin("lolo")).thenReturn(lolo);

        UserAroundev userReturned = userRepository.findByLogin("lolo");
        Assert.assertSame(userReturned.getFirstname(), lolo.getFirstname());
    }

    @Test
    public void getConnectectedUser_throughServiceSecurityContext_Test(){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Assert.assertSame(user.getUsername(), "admin");
    }

    @Test
    public void getConnectedUser_Test() throws UserNotFoundException {
        Mockito.when(userRepository.findByLogin("admin")).thenReturn(admin);

        UserAroundev userReturned = userBusiness.getConnectedUser();
        Assert.assertSame(userReturned, admin);
        Assert.assertSame(admin.getFirstname(), userReturned.getFirstname());
        //Roles
        //Assert.assertNotNull(userReturned.getRoles());
        //Assert.assertSame(userReturned.getRoles().size(), 2);
    }
}
