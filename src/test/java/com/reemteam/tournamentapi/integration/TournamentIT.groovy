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
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TournamentApiApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TournamentIT {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private TournamentRepository tournamentRepository

    @Test
    void shouldReturnAllTournaments() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("allTournaments.json").getFile()

        mockMvc.perform(get("/api/tournaments"))
        .andExpect(status().is(200))
        .andExpect(content().json(file.getText()))
    }
}
