package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Event;
import com.dungeonai.DungeonAi.entity.Game;
import com.dungeonai.DungeonAi.repository.EventRepository;
import com.dungeonai.DungeonAi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/{game_id}")
    public ResponseEntity<Event> create(@PathVariable("game_id") int gameId, @RequestBody Event event) {
        Optional<Game> game = gameRepository.findById(gameId);
        if (game.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        event.setGame(game.get());
        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.ok(savedEvent);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Event>> getAll() {
        ArrayList<Event> allEvents = new ArrayList<>();
        eventRepository.findAll().forEach(allEvents::add);
        return ResponseEntity.ok(allEvents);
    }
}
