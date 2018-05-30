package com.reemteam.tournamentapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonPatch;
import com.flipkart.zjsonpatch.JsonPatchApplicationException;
import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.TournamentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.reemteam.tournamentapi.model.TournamentType.ELIMINATION;
import static com.reemteam.tournamentapi.model.TournamentType.ROUND_ROBIN;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> createAllMatches(Tournament tournament){
        List<Match> matches;
        TournamentType tournamentType = tournament.getType();

        if(tournamentType.equals(ROUND_ROBIN)){
            matches = createRoundRobinMatches(tournament.getPlayers(), tournament.getId(), tournament.getHomeAwaysEach());
        } else {
            matches = createRoundRobinMatches(tournament.getPlayers(), tournament.getId(), tournament.getHomeAwaysEach());
        }

        tournament.setMatchesRemaining(matches.size());
        return matchRepository.save(matches);
    }

    private List<Match> createRoundRobinMatches(List<Integer> players, Integer tournamentId, Integer legsEach){
        List<Match> allMatches = new ArrayList<>();
        for(int j = 0; j < legsEach; j++) {
            List<Match> firstMatches = new ArrayList<>();
            List<Match> bothMatches = new ArrayList<>();

            for (Integer playerId : players) {
                int playerIndex = players.indexOf(playerId) + 1;

                for (int i = playerIndex; i < players.size(); i++) {
                    firstMatches.add(
                            Match.builder()
                                    .homePlayer(playerId)
                                    .awayPlayer(players.get(i))
                                    .tournamentId(tournamentId)
                                    .status("UNDECIDED")
                                    .build()
                    );
                }
            }

            bothMatches.addAll(firstMatches);

            for (Match match : firstMatches) {
                bothMatches.add(
                        Match.builder()
                                .homePlayer(match.getAwayPlayer())
                                .awayPlayer(match.getHomePlayer())
                                .tournamentId(tournamentId)
                                .status("UNDECIDED")
                                .build()
                );
            }

            allMatches.addAll(bothMatches);
        }

        return allMatches;
    }

    public List<Match> getMatchesByTournamentId(Integer tournamentId){
        return matchRepository.findByTournamentId(tournamentId);
    }

    public Match getMatchById(Integer matchId){
        return matchRepository.findOne(matchId);
    }

    public List<Match> getAllMatchesForPlayerId(Integer playerId){
        return matchRepository.findByHomePlayerOrAwayPlayer(playerId, playerId);
    }

}