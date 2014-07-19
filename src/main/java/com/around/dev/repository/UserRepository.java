package com.around.dev.repository;

import com.around.dev.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by laurent on 19/07/2014.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    long countById(int id);
}
