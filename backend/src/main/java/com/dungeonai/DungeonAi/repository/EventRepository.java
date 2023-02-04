package com.dungeonai.DungeonAi.repository;

import com.dungeonai.DungeonAi.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
