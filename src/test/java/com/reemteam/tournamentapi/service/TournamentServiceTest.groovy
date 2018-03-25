package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Tournament;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.sql.Date;

import static org.mockito.Mockito.*
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*

class TournamentServiceTest {

    TournamentRepository tournamentRepository = mock(TournamentRepository.class)
    TournamentService tournamentService;
    Tournament tournament



    @Before
    void setUp() throws Exception {
        tournamentService = new TournamentService(tournamentRepository)

        tournament = new Tournament()
        tournament.name = "Wooo best tournament"
        tournament.createdPlayer = 1
        tournament.endDate = Date.valueOf(LocalDate.of(2015, 02, 20))
        tournament.startDate = Date.valueOf(LocalDate.of(2015, 01, 01))
        tournament.matchesRemaining = 0
        tournament.winner = 1
        tournament.type = "Round Robin"
    }

    @Test
     void getAllTournaments() {
        List<Tournament> expectedTournaments = Lists.newArrayList(tournament)
        when(tournamentRepository.findAll()).thenReturn(expectedTournaments)

        List<Tournament> actualTournaments = tournamentService.getAllTournaments()
        assertEquals(expectedTournaments, actualTournaments)
    }

    @Test
    void getTournamentById() {
        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)

        Tournament actualTournament = tournamentService.getTournamentById(1)
        assertEquals(tournament, actualTournament)
    }

    @Test
    void createTournament() {
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualSavedTournament =  tournamentService.createTournament(tournament)
        assertEquals(tournament, actualSavedTournament)
    }

    @Test
    void updateTournament() {
        Tournament newTournament = new Tournament()
        newTournament.name = "Wooo worst tournament"
        newTournament.createdPlayer = 2
        newTournament.endDate = Date.valueOf(LocalDate.of(2018, 02, 20))
        newTournament.startDate = Date.valueOf(LocalDate.of(2015, 01, 01))
        newTournament.matchesRemaining = 0
        newTournament.winner = 1
        newTournament.type = "Round Robin"

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(newTournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, newTournament)

        assertEquals(newTournament, actualNewTournament)
    }
}