package com.around.dev.tests.User;

import com.around.dev.business.UserBusiness;
import com.around.dev.entity.Role;
import com.around.dev.entity.UserAroundev;
import com.around.dev.repository.RoleRepository;
import com.around.dev.repository.UserRepository;
import com.around.dev.security.UserSubscriptionInformations;
import com.around.dev.utils.enums.EnumRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * Created by laurent on 06/11/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserSubscriptionTests {

    @InjectMocks
    UserBusiness userBusiness;
    @Mock
    UserRepository userRepository;
    @Mock
    RoleRepository roleRepository;

    @Test
    public void signIn(){
        UserSubscriptionInformations newUser = new UserSubscriptionInformations()
                .setEmail("email@email.fr")
                .setFirstname("firstname")
                .setLastname("lastname")
                .setIsfemale(true)
                .setPublicname("publicname")
                .setPassword("cisco");

        Mockito.when(userRepository.saveAndFlush(Matchers.any(UserAroundev.class)))
                .thenAnswer(new Answer<UserAroundev>() {
                    @Override
                    public UserAroundev answer(InvocationOnMock invocationOnMock) throws Throwable {
                        return new UserAroundev().setId(1);
                    }
                });
        Mockito.when(roleRepository.findByName(EnumRole.USER))
                .thenAnswer(new Answer<Role>() {
                    @Override
                    public Role answer(InvocationOnMock invocationOnMock) throws Throwable {
                        return new Role().setId(1).setName(EnumRole.USER);
                    }
                });

        int id = userBusiness.signIn(newUser);
        Assert.assertSame(1, id);
    }

}
