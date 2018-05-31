package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Player;
import com.reemteam.tournamentapi.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByUsername(String username);
    Player findByEmail(String email);
}
