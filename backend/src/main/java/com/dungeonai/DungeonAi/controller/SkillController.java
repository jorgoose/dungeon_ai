package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Skill;
import com.dungeonai.DungeonAi.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Skills")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @PostMapping
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        Skill savedSkill = skillRepository.save(skill);
        return ResponseEntity.ok(savedSkill);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Skill>> getAll() {
        ArrayList<Skill> allSkills = new ArrayList<>();
        skillRepository.findAll().forEach(allSkills::add);
        return ResponseEntity.ok(allSkills);
    }
}
