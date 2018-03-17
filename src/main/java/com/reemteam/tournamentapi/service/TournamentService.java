package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TournamentService {

    private  TournamentRepository tournamentRepository;

    @Autowired
    public  TournamentService (TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(int id){
        return tournamentRepository.findOne(id);
    }

    public Tournament createTournament(Tournament tournament){
        return tournamentRepository.save(tournament);
    }

    public Tournament updateTournament(int id, Tournament tournamentNew){
        Tournament tournamentOld = tournamentRepository.findOne(id);
        return updateTournamentValues(tournamentOld, tournamentNew);
    }

    public void deleteTournamentById(int id){
        tournamentRepository.delete(id);
    }

    private Tournament updateTournamentValues(Tournament oldTournament, Tournament newTournament){
        oldTournament.setName(newTournament.getName());
        oldTournament.setType(newTournament.getType());
        oldTournament.setMatchesRemaining(newTournament.getMatchesRemaining());
        oldTournament.setWinner(newTournament.getWinner());
        oldTournament.setStartDate(newTournament.getStartDate());
        oldTournament.setEndDate(newTournament.getEndDate());
        oldTournament.setCreatedPlayer(newTournament.getCreatedPlayer());
        tournamentRepository.save(oldTournament);
        return oldTournament;
    }



}
