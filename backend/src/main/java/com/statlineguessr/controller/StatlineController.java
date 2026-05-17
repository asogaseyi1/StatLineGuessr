package com.statlineguessr.controller;

import com.statlineguessr.dto.StatlineGameView;
import com.statlineguessr.service.StatlineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StatlineController {
    private final StatlineService statlineService;

    public StatlineController(StatlineService statlineService) {
        this.statlineService = statlineService;
    }

    @GetMapping("/game/random")
    public ResponseEntity<StatlineGameView> getRandomStatline() {
        return statlineService.getRandomStatlineForGame()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/statlines")
    public ResponseEntity<?> getAllStatlines() {
        return ResponseEntity.ok(statlineService.getAll());
    }
}
