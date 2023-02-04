package com.dungeonai.DungeonAi.repository;


import com.dungeonai.DungeonAi.entity.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Integer> {
}
