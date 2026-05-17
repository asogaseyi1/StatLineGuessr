package com.statlineguessr.service;

import com.statlineguessr.dto.StatlineGameView;
import com.statlineguessr.model.Statline;

import java.util.List;
import java.util.Optional;

public interface StatlineService {
    Optional<StatlineGameView> getRandomStatlineForGame();
    Optional<Statline> findById(Long id);
    List<Statline> getAll();
}
