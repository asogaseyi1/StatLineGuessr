package com.statlineguessr.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record StatlineGameView(
        Long id,
        String sport,
        LocalDate gameDate,
        Integer points,
        Integer assists,
        Integer rebounds,
        Integer steals,
        Integer blocks,
        BigDecimal minutesPlayed
) {}
