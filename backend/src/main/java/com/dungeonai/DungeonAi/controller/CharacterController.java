package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Character;
import com.dungeonai.DungeonAi.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @PostMapping
    public ResponseEntity<Character> create(@RequestBody Character character) {
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
