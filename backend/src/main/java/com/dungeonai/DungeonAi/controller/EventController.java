package com.dungeonai.DungeonAi.controller;

import com.dungeonai.DungeonAi.entity.Event;
import com.dungeonai.DungeonAi.entity.Game;
import com.dungeonai.DungeonAi.repository.EventRepository;
import com.dungeonai.DungeonAi.repository.GameRepository;
import com.dungeonai.DungeonAi.service.EventService;
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

    @Autowired
    EventService eventService;

    @PostMapping("/{game_id}/{dice_roll}")
    public ResponseEntity<Event> create(@PathVariable("game_id") String gameId,
                                        @PathVariable("dice_roll") String diceRoll,
                                        @RequestBody Event event1) {
        int gameI = Integer.parseInt(gameId);
        int diceR = Integer.parseInt(diceRoll);
        Event event = new Event();
        Optional<Game> game = gameRepository.findById(gameI);
        if (game.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        event.setGame(game.get());

        try{
            event.setDescription(eventService.setUpEventDesc(diceR));
        }
        catch (InterruptedException e) {
            System.out.println("no go");
        }
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
