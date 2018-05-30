package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    List<Tournament> findByIdIn(List<Integer> tournamentIds);
}
