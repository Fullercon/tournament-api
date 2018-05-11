package com.reemteam.tournamentapi.unit

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reemteam.tournamentapi.model.Tournament
import com.reemteam.tournamentapi.service.TournamentRepository
import com.reemteam.tournamentapi.service.TournamentService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test
import org.springframework.core.io.ClassPathResource;

import java.time.LocalDate;
import java.sql.Date;

import static org.mockito.Mockito.*
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*

class TournamentService {

    TournamentRepository tournamentRepository = mock(TournamentRepository.class)
    com.reemteam.tournamentapi.service.TournamentService tournamentService;
    Tournament tournament



    @Before
    void setUp() throws Exception {
        tournamentService = new com.reemteam.tournamentapi.service.TournamentService(tournamentRepository)

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
    void updateWholeTournament() {
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

        Tournament actualNewTournament = tournamentService.updateWholeTournament(1, newTournament)

        assertEquals(newTournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotAddANewPath() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/addJsonPatchAddElement.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotAddArrayElementToPathThatIsNotAnArray() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/addJsonPatchAddToArray.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotAddToANewPathWithAnArray() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/addJsonPatchCreateArray.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }


    @Test
    void shouldReturnNewTournamentWithWinnerAndMatchesRemainingTheSameValueFromCopyperation() {

        Tournament newTournament = new Tournament()
        newTournament.name = "Wooo best tournament"
        newTournament.createdPlayer = 1
        newTournament.endDate = Date.valueOf(LocalDate.of(2015, 02, 20))
        newTournament.startDate = Date.valueOf(LocalDate.of(2015, 01, 01))
        newTournament.matchesRemaining = 1
        newTournament.winner = 1
        newTournament.type = "Round Robin"

        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/copyJsonPatchAlreadyExisitingPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(newTournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotCopyToAPathThatIsNotAnArray() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/copyJsonPatchInvalidArray.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotCopyToANewPath() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/copyJsonPatchInvalidPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotMoveToANewPath() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/moveJsonPatchInvalidPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnNewTournamentWithMatchesRemainingBeingThePreviousWinnerValueAndWinnerAsNull() {
        Tournament newTournament = new Tournament()
        newTournament.name = "Wooo best tournament"
        newTournament.createdPlayer = 1
        newTournament.endDate = Date.valueOf(LocalDate.of(2015, 02, 20))
        newTournament.startDate = Date.valueOf(LocalDate.of(2015, 01, 01))
        newTournament.matchesRemaining = 1
        newTournament.winner = null
        newTournament.type = "Round Robin"

        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/moveJsonPatchValidPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(newTournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotRemoveAnArrayThatDoesNotExist() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/removeJsonPatchInvalidArrayPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotRemoveAnPathThatDoesNotExist() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/removeJsonPatchInvalidPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnNewTournamentWithWinnerSetAsNull() {
        Tournament newTournament = new Tournament()
        newTournament.name = "Wooo best tournament"
        newTournament.createdPlayer = 1
        newTournament.endDate = Date.valueOf(LocalDate.of(2015, 02, 20))
        newTournament.startDate = Date.valueOf(LocalDate.of(2015, 01, 01))
        newTournament.matchesRemaining = 0
        newTournament.winner = null
        newTournament.type = "Round Robin"

        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/removeJsonPatchValidPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(newTournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotReplaceValueInPathThatIsNotAnArray() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/replaceJsonPatchInvalidArray.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentAsCannotReplaceValueInNonExistentPath() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/replaceJsonPatchInvalidPath.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentWithNullOperator() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/nullJsonPatch.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldReturnExistingTournamentWhenNullPassedThrough() {
        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, null)

        assertEquals(tournament, actualNewTournament)
    }

    @Test
    void shouldTournamentWithTheNameChanged() {
        Tournament newTournament = new Tournament()
        newTournament.name = "Test Tournament :)"
        newTournament.createdPlayer = 1
        newTournament.endDate = Date.valueOf(LocalDate.of(2015, 02, 20))
        newTournament.startDate = Date.valueOf(LocalDate.of(2015, 01, 01))
        newTournament.matchesRemaining = 0
        newTournament.winner = 1
        newTournament.type = "Round Robin"

        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("unit/replaceJsonPatchValid.json").getFile()
        JsonNode patch = objectMapper.readTree(file)

        when(tournamentRepository.findOne(anyInt())).thenReturn(tournament)
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament)

        Tournament actualNewTournament = tournamentService.updateTournament(1, patch)

        assertEquals(newTournament, actualNewTournament)
        assertEquals("Test Tournament :)", actualNewTournament.name)
    }


}