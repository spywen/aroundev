package com.around.dev.repository.planningPoker;

import com.around.dev.entity.planningpoker.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by laurent on 27/07/2014.
 */
public interface VoteRepository extends JpaRepository<Vote, Integer>{
}
