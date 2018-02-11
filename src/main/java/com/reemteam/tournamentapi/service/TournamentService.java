package com.reemteam.tournamentapi.service;

import com.reemteam.tournamentapi.model.Match;
import com.reemteam.tournamentapi.model.Tournament;
import com.reemteam.tournamentapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TournamentService {
    private static List<Tournament> tournaments;

//    static {
//        User t1 = User.builder()
//                .username("boobies")
//                .avatarFilePath("C:/boobies.jpg")
//                .email("boob@boobies.com")
//                .password("password")
//                .id(1)
//                .build();
//        User t2 = User.builder()
//                .username("boobies2")
//                .avatarFilePath("C:/boobies.jpg")
//                .email("boob@boobies.com")
//                .password("password")
//                .id(2)
//                .build();
//
//        Match match = Match.builder()
//                .awayPlayer(t1)
//                .homePlayer(t2)
//                .id(1)
//                .tournamentId(1)
//                .status("Undecided")
//                .winner(null)
//                .build();
//
//        Tournament tournament = Tournament.builder()
//                .id(1)
//                .endDate(new Date())
//                .startDate(new Date())
//                .matches(new ArrayList<>(Arrays.asList(match)))
//                .matchesRemaining(1)
//                .name("Boobies")
//                .players(new ArrayList<>(Arrays.asList(t1, t2)))
//                .type("Round Robin")
//                .createdUser(t1)
//                .winner(null)
//                .build();
//
//        tournaments = new ArrayList<>(Arrays.asList(tournament, tournament.toBuilder().id(2).build()));
//
//    }
//
//    public List<Tournament> getAllTournaments(){
//        return tournaments;
//    }
//
//    public Tournament getTournamentById(int id){
//        Tournament tournamentFound = null;
//        for(Tournament tournament: tournaments){
//            if(tournament.getId() == id){
//                tournamentFound = tournament;
//            }
//        }
//        return tournamentFound;
//    }
//
//    public int getTournamentIndexById(int id){
//        int index = 999;
//        for(int i=0;i<tournaments.size();i++){
//            if(tournaments.get(i).getId() == id){
//                index = i;
//            }
//        }
//        return index;
//    }
//
//    public Tournament createTournament(Tournament tournament){
//        tournament = tournament.toBuilder().id(tournaments.size()+1).build();
//        tournaments.add(tournament);
//        return tournament;
//    }
//
//    public Tournament updateTournament(int id, Tournament tournament){
//        int indexToUpdate = getTournamentIndexById(id);
//        tournaments.set(indexToUpdate, tournament);
//        return tournament;
//    }
//
//    public Tournament deleteTournamentById(int id){
//        Tournament tournamentToDelete = getTournamentById(id);
//        tournaments.remove(tournamentToDelete);
//        return tournamentToDelete;
//    }
//
//

}
