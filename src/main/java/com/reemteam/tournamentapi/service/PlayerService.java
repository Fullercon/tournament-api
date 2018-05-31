package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.exception.EmailAlreadyInUseException;
import com.reemteam.tournamentapi.exception.UsernameAlreadyExistsException;
import com.reemteam.tournamentapi.model.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static com.reemteam.tournamentapi.model.TournamentType.ROUND_ROBIN;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player newPlayer){
        if(usernameAlreadyExists(newPlayer.getUsername())){
            throw new UsernameAlreadyExistsException();
        }
        if(emailAlreadyExists(newPlayer.getEmail())){
            throw new EmailAlreadyInUseException();
        }

        return playerRepository.save(newPlayer);
    }

    public boolean deleteLoggedInUser(Principal principal) {
        Player loggedInUser = findLoggedInUser(principal);
        if (loggedInUser != null) {
            playerRepository.delete(loggedInUser);
            return true;
        }
        return false;
    }

    private Player findLoggedInUser(Principal principal) {
        return playerRepository.findByUsername(principal.getName());
    }

    private boolean usernameAlreadyExists(String username){
        return playerRepository.findByUsername(username) != null;
    }

    private boolean emailAlreadyExists(String email){
        return playerRepository.findByEmail(email) != null;
    }


}