package com.statlineguessr.service;

import com.statlineguessr.model.Player;
import com.statlineguessr.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> searchByName(String query) {
        return playerRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public Optional<Player> findByName(String name) {
        return playerRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }
}
