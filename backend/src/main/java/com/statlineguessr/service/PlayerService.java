package com.statlineguessr.service;

import com.statlineguessr.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<Player> getAllPlayers();
    List<Player> searchByName(String query);
    Optional<Player> findByName(String name);
    Player save(Player player);
}
