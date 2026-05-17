package com.statlineguessr.dto;

public record GuessResult(
        boolean correct,
        String actualPlayerName,
        String team,
        String position,
        String sport,
        String message
) {}
