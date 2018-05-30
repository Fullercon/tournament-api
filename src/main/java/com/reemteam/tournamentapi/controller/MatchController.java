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

import java.util.List;

@Controller
@RequestMapping("/api")
public class MatchController {

    @Autowired
    MatchService matchService;

    @RequestMapping(path="/matches/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Match getMatch(@PathVariable("id") int id){
        return matchService.getMatchById(id);
    }

    @RequestMapping(path="/matches/user/{userId}", method=RequestMethod.GET)
    @ResponseBody
    public List<Match> getAllMatchesForUser (@PathVariable("userId") int userId) {
        return matchService.getAllMatchesForPlayerId(userId);
    }

}
