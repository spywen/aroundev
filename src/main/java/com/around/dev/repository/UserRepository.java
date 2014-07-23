package com.around.dev.repository;

import com.around.dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by laurent on 19/07/2014.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    long countById(int id);
    User findByLogin(String login);
}
