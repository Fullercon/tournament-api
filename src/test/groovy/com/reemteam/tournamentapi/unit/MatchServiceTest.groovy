package com.reemteam.tournamentapi.unit

import com.reemteam.tournamentapi.model.Match
import com.reemteam.tournamentapi.model.MatchStatus
import com.reemteam.tournamentapi.model.Tournament
import com.reemteam.tournamentapi.service.MatchRepository
import com.reemteam.tournamentapi.service.MatchService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.runners.MockitoJUnitRunner

import static com.reemteam.tournamentapi.model.MatchStatus.UNDECIDED
import static com.reemteam.tournamentapi.model.TournamentType.ROUND_ROBIN
import static org.junit.Assert.assertEquals
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner.class)
class MatchServiceTest {

    private MatchRepository matchRepository = mock(MatchRepository.class)

    MatchService matchService
    Tournament tournament

    @Before
    void setUp() throws Exception {
        matchService = new MatchService(matchRepository)
        tournament = new Tournament()
    }

    @Test
     void shouldCreateAllMatchesIfRoundRobinTournament() {
        tournament.type = ROUND_ROBIN
        tournament.players = [1,3,5]
        tournament.id = 1000
        tournament.homeAwaysEach = 1
        List<Match> expectedMatches = new ArrayList<>()
        expectedMatches.add(createMatch(1,3, tournament.id))
        expectedMatches.add(createMatch(3,1, tournament.id))
        expectedMatches.add(createMatch(1,5, tournament.id))
        expectedMatches.add(createMatch(5,1, tournament.id))
        expectedMatches.add(createMatch(3,5, tournament.id))
        expectedMatches.add(createMatch(5,3, tournament.id))

        ArgumentCaptor<List> argument=ArgumentCaptor.forClass(List.class)

        matchService.createAllMatches(tournament)
        verify(matchRepository).save((List<Match>)argument.capture())
        List<Match> matches = argument.getValue()
        assertEquals(matches.size(), expectedMatches.size())
        assert matches.containsAll(expectedMatches)
    }

    @Test
    void shouldCreateAllMatchesNTimesIfSpecifiedRoundRobinTournament() {
        tournament.type = ROUND_ROBIN
        tournament.players = [1,3,5]
        tournament.id = 1000
        tournament.homeAwaysEach = 3
        List<Match> expectedMatches = new ArrayList<>()
        expectedMatches.add(createMatch(1,3, tournament.id))
        expectedMatches.add(createMatch(3,1, tournament.id))
        expectedMatches.add(createMatch(1,5, tournament.id))
        expectedMatches.add(createMatch(5,1, tournament.id))
        expectedMatches.add(createMatch(3,5, tournament.id))
        expectedMatches.add(createMatch(5,3, tournament.id))

        ArgumentCaptor<List> argument=ArgumentCaptor.forClass(List.class)

        matchService.createAllMatches(tournament)
        verify(matchRepository).save((List<Match>)argument.capture())
        List<Match> matches = argument.getValue()
        assertEquals(matches.size(), expectedMatches.size() * tournament.homeAwaysEach)
        assert matches.containsAll(expectedMatches)
    }

    private static Match createMatch(int homePlayer, int awayPlayer, int tournId){
        return Match.builder()
                    .homePlayer(homePlayer)
                    .awayPlayer(awayPlayer)
                    .status(UNDECIDED)
                    .tournamentId(tournId)
                    .winner(null)
                    .build()
    }
}