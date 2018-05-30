package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByTournamentId(Integer tournamentId);

    List<Match> findByHomePlayerOrAwayPlayer(Integer homePlayer, Integer awayPlayer);
}
