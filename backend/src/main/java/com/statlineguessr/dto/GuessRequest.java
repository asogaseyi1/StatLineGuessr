package com.statlineguessr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GuessRequest(
        @NotNull Long statlineId,
        @NotBlank String guessedPlayerName
) {}
