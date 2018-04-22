package com.reemteam.tournamentapi.controller;

import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api")
public class TournamentController {

    @RequestMapping(path="/", method=RequestMethod.GET)
    @ResponseBody
    public String createTournament(){
        return "hello";
    }

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

    @RequestMapping(path="/tournaments/{id}", method=RequestMethod.PATCH)
    @ResponseBody
    public Tournament updateTournament(@PathVariable("id") int id, @RequestBody Map<String, String> updates){
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
