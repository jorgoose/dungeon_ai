package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Game;
import com.dungeonai.DungeonAi.repository.GameRepository;
import com.dungeonai.DungeonAi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CharacterService characterService;

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game) throws IOException {
        Game savedGame = gameRepository.save(game);
        try {
            characterService.createCharacter();
        } catch (IOException e) {
            System.out.println("shit don\'t work");
        }
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Game>> getAll() {
        ArrayList<Game> allGames = new ArrayList<>();
        gameRepository.findAll().forEach(allGames::add);
        return ResponseEntity.ok(allGames);
    }
}
