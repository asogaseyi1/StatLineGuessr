package com.statlineguessr.service;

import com.statlineguessr.dto.GuessRequest;
import com.statlineguessr.dto.GuessResult;

public interface GuessService {
    GuessResult submitGuess(GuessRequest request);
}
