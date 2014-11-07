package com.around.dev.repository;

import com.around.dev.entity.UserAroundev;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by laurent on 19/07/2014.
 */
public interface UserRepository extends JpaRepository<UserAroundev, Integer>{
    long countById(int id);
    UserAroundev findByLogin(String login);
    long countBySupinfoid(int supinfoid);
    long countByEmail(String email);
    long countByLogin(String login);
}
