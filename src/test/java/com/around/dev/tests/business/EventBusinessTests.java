package com.around.dev.tests.business;

import com.around.dev.business.EventBusiness;
import com.around.dev.business.UserBusiness;
import com.around.dev.entity.Role;
import com.around.dev.entity.UserAroundev;
import com.around.dev.repository.EventRepository;
import com.around.dev.utils.enums.EnumRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by laurent on 10/11/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class EventBusinessTests {
    @InjectMocks
    EventBusiness eventBusiness;
    @Mock
    EventRepository eventRepository;
    @Mock
    UserBusiness userBusiness;

    static UserAroundev supinfoNiceUser = new UserAroundev();

    @Before
    public void onSetUp() {
        supinfoNiceUser.setId(1);
        supinfoNiceUser.setFirstname("supinfoNiceUser");
        supinfoNiceUser.setEmail("supinfoNiceUser@supinfoNiceUser.com");
        supinfoNiceUser.setIsactive(true);
        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setName(EnumRole.SUPINFO_NICE);
        Role userRole = new Role();
        userRole.setId(2);
        userRole.setName(EnumRole.USER);
        Set<Role> roles = new HashSet<Role>(Arrays.asList(adminRole, userRole));
        supinfoNiceUser.setRoles(roles);

        //Init injection
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_have_injection_done() {
        Assert.assertNotNull(eventBusiness);
    }

    /*@Test
    public void save_NominalCase() throws UserNotFoundException {
        Mockito.when(userBusiness.getConnectedUser()).thenReturn(supinfoNiceUser);

        Mockito.when(eventRepository.save(Matchers.any(Event.class)))
                .thenAnswer(new Answer<Event>() {
                    @Override
                    public Event answer(InvocationOnMock invocationOnMock) throws Throwable {
                        return new Event().setId(11);
                    }
                });

        Event savedEvent = eventBusiness.save(new Event().setTitle("MyEvent").setDescription("desc").setStartdate(new Timestamp(new Date().getTime())));

        Assert.assertSame(11, savedEvent.getId());
        Assert.assertSame("supinfoNiceUser", savedEvent.getOwner().getLogin());
    }*/

}
