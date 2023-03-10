package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Character;
import com.dungeonai.DungeonAi.entity.Game;
import com.dungeonai.DungeonAi.repository.GameRepository;
import com.dungeonai.DungeonAi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

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
        return ResponseEntity.ok(savedGame);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Game>> getAll() {
        ArrayList<Game> allGames = new ArrayList<>();
        gameRepository.findAll().forEach(allGames::add);
        return ResponseEntity.ok(allGames);
    }

    @GetMapping("/{game_id}/characters")
    public ResponseEntity<Set<Character>> getAllCharacters(@PathVariable("game_id") int gameId) {
        Game game = gameRepository.findById(gameId).get();
        return ResponseEntity.ok(game.getCharacters());
    }
}
