package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Game;
import com.dungeonai.DungeonAi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/create")
    public ResponseEntity<Game> create(@RequestBody Game game) {
        Game savedGame = gameRepository.save(game);
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Game>> getAll() {
        ArrayList<Game> allGames = new ArrayList<>();
        gameRepository.findAll().forEach(allGames::add);
        return ResponseEntity.ok(allGames);
    }
}
