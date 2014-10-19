package com.around.dev.repository.planningPoker;

import com.around.dev.entity.planningpoker.StoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by laurent on 27/07/2014.
 */
public interface StoryStatusRepository extends JpaRepository<StoryStatus, Integer>{
}