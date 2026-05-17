package com.statlineguessr.controller;

import com.statlineguessr.dto.GuessRequest;
import com.statlineguessr.dto.GuessResult;
import com.statlineguessr.service.GuessService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guess")
public class GuessController {
    private final GuessService guessService;

    public GuessController(GuessService guessService) {
        this.guessService = guessService;
    }

    @PostMapping
    public ResponseEntity<GuessResult> submitGuess(@Valid @RequestBody GuessRequest request) {
        return ResponseEntity.ok(guessService.submitGuess(request));
    }
}
