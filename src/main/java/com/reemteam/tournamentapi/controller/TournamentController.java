package com.reemteam.tournamentapi.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.service.MatchService;
import com.reemteam.tournamentapi.service.TournamentPlayerService;
import com.reemteam.tournamentapi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    TournamentPlayerService tournamentPlayerService;

    @Autowired
    MatchService matchService;

    @RequestMapping(path="/tournaments", method=RequestMethod.POST)
    @ResponseBody
    public Tournament createTournament(@RequestBody Tournament tournamentBody){
        Tournament tournament = tournamentService.createTournament(tournamentBody);
        matchService.createAllMatches(tournament);
        tournamentPlayerService.createTournamentPlayers(tournament.getId(), tournamentBody.getPlayers());
        return tournament;
    }

    @RequestMapping(path="/tournaments", method=RequestMethod.GET)
    @ResponseBody
    public List<Tournament> getAllTournaments () {
        return tournamentService.getAllTournaments();
    }

    @RequestMapping(path="/tournaments/user/{userId}", method=RequestMethod.GET)
    @ResponseBody
    public List<Tournament> getAllTournamentsForUser (@PathVariable("userId") int userId) {
        List<Integer> tournamentIds = tournamentPlayerService.getAllTournamentsIdsForPlayer(userId);
        return tournamentService.getAllTournamentsWithIds(tournamentIds);
    }

    @RequestMapping(path="/tournaments/{id}/matches", method=RequestMethod.GET)
    @ResponseBody
    public List<Match> getAllMatchesForTournament (@PathVariable("id") int id) {
        return matchService.getMatchesByTournamentId(id);
    }

    @RequestMapping(path="/tournaments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tournament getTournament(@PathVariable("id") int id){
        Tournament tournament = tournamentService.getTournamentById(id);
        tournament.setPlayers(tournamentPlayerService.getPlayersForTournamentId(id));
        return tournament;
    }

    @RequestMapping(path="/tournaments/{id}", method=RequestMethod.PATCH)
    @ResponseBody
    public Tournament updateTournament(@PathVariable("id") int id, @RequestBody JsonNode updates){
        return tournamentService.updateTournament(id, updates);
    }

    @RequestMapping(path="/tournaments/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Tournament updateWholeTournament(@PathVariable("id") int id, @RequestBody Tournament tournamentBody){
        return tournamentService.updateWholeTournament(id, tournamentBody);
    }

    @RequestMapping(path="/tournaments/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteTournament(@PathVariable("id") int id){
        tournamentService.deleteTournamentById(id);
    }

}
