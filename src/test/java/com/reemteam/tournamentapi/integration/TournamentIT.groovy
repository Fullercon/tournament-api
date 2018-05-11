package com.reemteam.tournamentapi.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.reemteam.tournamentapi.TournamentApiApplication
import com.reemteam.tournamentapi.service.TournamentRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TournamentIT {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private TournamentRepository tournamentRepository

    @Test
    void shouldReturnAllTournaments() throws Exception{
        File file = new ClassPathResource("integration/allTournaments.json").getFile()

        mockMvc.perform(get("/api/tournaments"))
        .andExpect(status().is(200))
        .andExpect(content().json(file.getText()))
    }

    @Test
    void shouldUpdateNameAndWinner() {
        File patchRequest = new ClassPathResource("integration/patchRequests/updatedNameAndWinner.json").getFile()
        File expected = new ClassPathResource("integration/patchUpdatedNameAndWinnerResult.json").getFile()

        mockMvc.perform(
                patch("/api/tournaments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(patchRequest.getText()))
                .andExpect(status().is(200))
                .andExpect(content().json(expected.getText()))
    }


    @Test
    void shouldNotUpdateNameAndWinnerWithInvalidPatchRequest() {
        File patchRequest = new ClassPathResource("integration/patchRequests/doNotChangeTournament.json").getFile()
        File expected = new ClassPathResource("integration/unchangedTournamentPatchRequest.json").getFile()

        mockMvc.perform(
                patch("/api/tournaments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(patchRequest.getText()))
                .andExpect(status().is(200))
                .andExpect(content().json(expected.getText()))
    }
}
