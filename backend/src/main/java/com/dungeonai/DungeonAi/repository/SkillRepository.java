package com.dungeonai.DungeonAi.repository;

import com.dungeonai.DungeonAi.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
