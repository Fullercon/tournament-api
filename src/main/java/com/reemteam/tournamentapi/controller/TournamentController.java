package com.reemteam.tournamentapi.controller;

import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.User;
import com.reemteam.tournamentapi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @RequestMapping(path="/tournaments", method=RequestMethod.POST)
    @ResponseBody
    public Tournament createTournament(@RequestBody Tournament tournamentBody){
        return tournamentService.createTournament(tournamentBody);
    }

    @RequestMapping(path="/tournaments", method=RequestMethod.GET)
    @ResponseBody
    public List<Tournament> getAllTournaments () {
        return tournamentService.getAllTournaments();
    }

    @RequestMapping(path="/tournaments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tournament getTournament(@PathVariable("id") int id){
        return tournamentService.getTournamentById(id);
    }

    @RequestMapping(path="/tournaments/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Tournament updateTournament(@PathVariable("id") int id, @RequestBody Tournament tournamentBody){
        return tournamentService.updateTournament(id, tournamentBody);
    }

    @RequestMapping(path="/tournaments/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public Tournament deleteTournament(@PathVariable("id") int id){
        return tournamentService.deleteTournamentById(id);
    }

}
