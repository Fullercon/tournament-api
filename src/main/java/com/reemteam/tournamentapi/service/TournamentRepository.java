package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
