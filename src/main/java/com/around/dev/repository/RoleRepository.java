package com.around.dev.repository;

import com.around.dev.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by laurent on 06/11/14.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
