package com.dungeonai.DungeonAi.repository;

import com.dungeonai.DungeonAi.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
