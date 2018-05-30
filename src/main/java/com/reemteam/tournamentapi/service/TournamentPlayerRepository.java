package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.TournamentPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentPlayerRepository extends JpaRepository<TournamentPlayer, Integer> {
    List<TournamentPlayer> findByPlayerId(Integer playerId);
    List<TournamentPlayer> findByTournamentId(Integer tournamentId);
}
