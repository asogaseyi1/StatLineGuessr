package com.statlineguessr.service;

import com.statlineguessr.dto.StatlineGameView;
import com.statlineguessr.model.Statline;
import com.statlineguessr.repository.StatlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatlineServiceImpl implements StatlineService {
    private final StatlineRepository statlineRepository;

    public StatlineServiceImpl(StatlineRepository statlineRepository) {
        this.statlineRepository = statlineRepository;
    }

    @Override
    public Optional<StatlineGameView> getRandomStatlineForGame() {
        return statlineRepository.findRandom().map(this::toGameView);
    }

    @Override
    public Optional<Statline> findById(Long id) {
        return statlineRepository.findById(id);
    }

    @Override
    public List<Statline> getAll() {
        return statlineRepository.findAll();
    }

    private StatlineGameView toGameView(Statline s) {
        return new StatlineGameView(
                s.getId(),
                s.getPlayer().getSport(),
                s.getGameDate(),
                s.getPoints(),
                s.getAssists(),
                s.getRebounds(),
                s.getSteals(),
                s.getBlocks(),
                s.getMinutesPlayed()
        );
    }
}
