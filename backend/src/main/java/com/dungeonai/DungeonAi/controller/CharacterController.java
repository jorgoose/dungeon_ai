package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Character;
import com.dungeonai.DungeonAi.entity.Game;
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
        character.setGame(game.get());
        skillRepository.findAll().forEach(character::addSkill);
        Character savedCharacter = characterRepository.save(character);
        try {
            characterService.createCharacter();
        } catch (IOException e) {
            System.out.println("no go");
        }
        return ResponseEntity.ok(savedCharacter);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Character>> getAll() {
        ArrayList<Character> allCharacters = new ArrayList<>();
        characterRepository.findAll().forEach(allCharacters::add);
        return ResponseEntity.ok(allCharacters);
    }
}
