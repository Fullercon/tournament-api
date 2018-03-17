package com.reemteam.tournamentapi.integrationTests;

import com.reemteam.tournamentapi.service.TournamentRepository;
import com.reemteam.tournamentapi.service.TournamentService;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TournamentIT {
    @Autowired
    private TournamentService tournamentService;
    @Mock
    private TournamentRepository tournamentRepository;


}
