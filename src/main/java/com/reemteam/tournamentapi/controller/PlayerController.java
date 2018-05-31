package com.reemteam.tournamentapi.controller;

import com.reemteam.tournamentapi.model.Player;
import com.reemteam.tournamentapi.model.PlayerResponse;
import com.reemteam.tournamentapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(path="/players", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PlayerResponse> createPlayer(@RequestBody Player newPlayer){
        Player createdPlayer = playerService.createPlayer(newPlayer);
        PlayerResponse response = buildPlayerResponse(createdPlayer);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(path="/players/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Player getPlayerById (@PathVariable("id") Integer id) {
        return null;
    }


    //Deletes the currently logged in user
    @RequestMapping(path="/players}", method=RequestMethod.DELETE)
    public ResponseEntity deleteUser(Principal principal) {
        if (playerService.deleteLoggedInUser(principal)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    private PlayerResponse buildPlayerResponse(Player player){
        return PlayerResponse.builder()
                .id(player.getId())
                .email(player.getEmail())
                .username(player.getUsername())
                .avatarFilePath(player.getAvatarFilePath())
                .build();
    }

}
