package com.around.dev.tests.User;

import com.around.dev.configs.JpaConfigs;
import com.around.dev.entity.UserAroundev;
import com.around.dev.repository.UserRepository;
import com.excilys.ebi.spring.dbunit.config.DBOperation;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.sql.Timestamp;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfigs.class}, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(value = "/data/UserRepositoryDataset.xml", tearDownOperation = DBOperation.DELETE_ALL)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_find_by_email(){
        assertThat(userRepository.findByEmail("test@aroudev.com")).isNotNull();
    }

    @Test
    public void should_add_user(){
        UserAroundev newUser = new UserAroundev().setEmail("newuser@aroundev.com").setFirstname("NewUSer")
                .setIsactive(true).setIsfemale(false).setLastname("Aroundev")
                .setLogin("newusertest").setPassword("test").setRegisterdate(new Timestamp(System.currentTimeMillis()))
                .setSupinfoid(5);

        userRepository.save(newUser);

        assertThat(userRepository.findByEmail(newUser.getEmail())).isNotNull();
    }

}
