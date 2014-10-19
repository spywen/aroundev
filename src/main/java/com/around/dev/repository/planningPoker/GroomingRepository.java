package com.around.dev.repository.planningPoker;

import com.around.dev.entity.planningpoker.Grooming;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by laurent on 27/07/2014.
 */
public interface GroomingRepository extends JpaRepository<Grooming, Integer> {
    List<Grooming> findAllByModerator(int id);
}
