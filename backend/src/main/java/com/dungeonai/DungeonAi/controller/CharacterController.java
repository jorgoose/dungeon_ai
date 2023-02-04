package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Character;
import com.dungeonai.DungeonAi.entity.Game;
import com.dungeonai.DungeonAi.entity.Skill;
import com.dungeonai.DungeonAi.repository.CharacterRepository;
import com.dungeonai.DungeonAi.repository.GameRepository;
import com.dungeonai.DungeonAi.repository.SkillRepository;
import com.dungeonai.DungeonAi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    CharacterService characterService;

    @PostMapping("/{game_id}")
    public ResponseEntity<Character> create(@PathVariable("game_id") int gameId, @RequestBody Character character) {
        Optional<Game> game = gameRepository.findById(gameId);
        if (game.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        character.setBackground("Lorem Epsum");
        character.setMaxHealth(100);
        character.setCurrentHealth(100);
        character.setImage("Basse64String");
        character.setGame(game.get());
        for(Skill skill : skillRepository.findAll()) {
            if(skill.isDefault()) {
                character.addSkill(skill);
            }
        }

        Character savedCharacter = characterRepository.save(character);
        try {
            characterService.createCharacter();
        } catch (IOException e) {
            System.out.println("no go");
        }
        return ResponseEntity.ok(savedCharacter);
    }

    @PutMapping("/{character_id}/skills")
    public ResponseEntity<Character> updateSkills(@PathVariable("character_id") int characterId, @RequestBody Set<Skill> skills) {
        Optional<Character> character = characterRepository.findById(characterId);
        if (character.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        character.get().setSkills(skills);
        Character savedCharacter = characterRepository.save(character.get());
        return ResponseEntity.ok(savedCharacter);
    }

    @PutMapping("/{character_id}")
    public ResponseEntity<Character> update(@PathVariable("character_id") int characterId, @RequestBody Character character) {
        Optional<Character> optionalCharacter = characterRepository.findById(characterId);
        if (optionalCharacter.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        character.setId(characterId);
        character.setGame(optionalCharacter.get().getGame());
        character.setSkills(optionalCharacter.get().getSkills());
        Character savedCharacter = characterRepository.save(character);
        return ResponseEntity.ok(savedCharacter);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Character>> getAll() {
        ArrayList<Character> allCharacters = new ArrayList<>();
        characterRepository.findAll().forEach(allCharacters::add);
        return ResponseEntity.ok(allCharacters);
    }
}
