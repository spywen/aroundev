package com.around.dev.repository;

import com.around.dev.entity.eventmanager.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by laurent on 10/11/14.
 */
public interface EventRepository extends JpaRepository<Event, Integer>, JpaSpecificationExecutor {
}
