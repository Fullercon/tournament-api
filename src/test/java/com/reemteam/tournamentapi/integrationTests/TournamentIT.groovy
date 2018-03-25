package com.reemteam.tournamentapi.integrationTests

import com.fasterxml.jackson.databind.ObjectMapper
import com.reemteam.tournamentapi.TournamentApiApplication
import com.reemteam.tournamentapi.controller.TournamentController
import com.reemteam.tournamentapi.model.Tournament
import com.reemteam.tournamentapi.service.TournamentRepository
import jdk.internal.org.objectweb.asm.TypeReference
import org.apache.tools.ant.util.TeeOutputStream
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.mockito.Mockito.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TournamentIT {

    @Autowired
    private MockMvc mockMvc

    @MockBean
    private TournamentRepository tournamentRepository

    @Before
    void setup () {

    }

    @Test
    void shouldReturnAllTournaments() {
        ObjectMapper objectMapper = new ObjectMapper()
        File file = new ClassPathResource("allTournaments.json").getFile();
        List<Tournament> expected = objectMapper.readValue(file, Tournament[].class)

        mockMvc.perform(get("/api/tournaments"))
        .andExpect(status().is(200))
        .andExpect(content().json(file.getText()))

    }


}
