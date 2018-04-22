package com.reemteam.tournamentapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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

    public Tournament updateTournament(int id, Map<String, String> updatedFields){
        Tournament tournament = tournamentRepository.findOne(id);
        tournament = updateCorrectFields(updatedFields, tournament);
        tournamentRepository.save(tournament);
        return tournament;
    }

    public Tournament updateWholeTournament(int id, Tournament tournamentNew){
        Tournament tournamentOld = tournamentRepository.findOne(id);
        return updateTournamentValues(tournamentOld, tournamentNew);
    }

    public void deleteTournamentById(int id){
        tournamentRepository.delete(id);
    }

    private Tournament updateCorrectFields(Map<String, String> updatedFields, Tournament tournament) {
        for (Map.Entry<String, String> entry : updatedFields.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                    tournament.setName(entry.getValue());
                    break;
                case "type":
                    tournament.setType(entry.getValue());
                    break;
                case "matchesRemaining":
                    tournament.setMatchesRemaining(convertToInt(entry.getValue()));
                    break;
                case "winner":
                    tournament.setWinner(convertToInt(entry.getValue()));
                    break;
                case "startDate":
                    Date newStartDate = parseDate(entry.getKey(), entry.getValue());
                    if(newStartDate != null) tournament.setStartDate(newStartDate);
                    break;
                case "endDate":
                    Date newEndDate = parseDate(entry.getKey(), entry.getValue());
                    if(newEndDate != null) tournament.setStartDate(newEndDate);
                    break;
                case "createdPlayer":
                    tournament.setCreatedPlayer(convertToInt(entry.getValue()));
                    break;
            }
        }
        return tournament;
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

    private int convertToInt (String integer) {
        return Integer.parseInt(integer);
    }

    private Date parseDate (String date, String dateValue) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
        } catch (ParseException e) {
            System.out.println("Unable to parse " + date + " value of " + date);
            return null;
        }
    }

}
