package com.reemteam.tournamentapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonPatch;
import com.flipkart.zjsonpatch.JsonPatchApplicationException;
import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Tournament updateTournament(int id, JsonNode jsonPatch){
        ObjectMapper mapper = new ObjectMapper();
        Tournament tournament = tournamentRepository.findOne(id);
        try {
            JsonNode sourceTournament = mapper.valueToTree(tournament);
            JsonNode updatedTournament = JsonPatch.apply(jsonPatch, sourceTournament);
            tournament = mapper.treeToValue(updatedTournament, Tournament.class);
            tournamentRepository.save(tournament);
        } catch (JsonProcessingException e) {
            System.out.println("Error processing json in patch request. Cannot add fields. " + e);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Cannot remove data " + e.getMessage());
        } catch (JsonPatchApplicationException e) {
            System.out.println("Operation used is invalid " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something bad happened " + e.getMessage());
        }
        return tournament;
    }

    public Tournament updateWholeTournament(int id, Tournament tournamentNew){
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
