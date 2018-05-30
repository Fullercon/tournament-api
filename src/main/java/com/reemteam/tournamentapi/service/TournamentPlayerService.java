package com.reemteam.tournamentapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonPatch;
import com.flipkart.zjsonpatch.JsonPatchApplicationException;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.TournamentPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentPlayerService {

    private TournamentPlayerRepository tournamentPlayerRepository;

    @Autowired
    public TournamentPlayerService(TournamentPlayerRepository tournamentPlayerRepository) {
        this.tournamentPlayerRepository = tournamentPlayerRepository;
    }

    public void createTournamentPlayers(Integer tournamentId, List<Integer> playerIds){
        for(Integer playerId : playerIds){
            TournamentPlayer player = new TournamentPlayer(tournamentId, playerId);
            tournamentPlayerRepository.save(player);
        }
    }

    public List<Integer> getPlayersForTournamentId(Integer tournamentId){
        List<TournamentPlayer> playersInTournament = tournamentPlayerRepository.findByTournamentId(tournamentId);
        return getPlayerIdsFromTournamentPlayerList(playersInTournament);
    }

    public List<Integer> getAllTournamentsIdsForPlayer(Integer playerId){
        List<TournamentPlayer> tournamentsForPlayer = tournamentPlayerRepository.findByPlayerId(playerId);
        return getTournamentIdsFromTournamentPlayerList(tournamentsForPlayer);
    }

    private List<Integer> getTournamentIdsFromTournamentPlayerList(List<TournamentPlayer> tournamentPlayers){
        return tournamentPlayers.stream()
                .map(TournamentPlayer::getTournamentId)
                .collect(Collectors.toList());
    }

    private List<Integer> getPlayerIdsFromTournamentPlayerList(List<TournamentPlayer> tournamentPlayers){
        return tournamentPlayers.stream()
                .map(TournamentPlayer::getPlayerId)
                .collect(Collectors.toList());
    }
}
