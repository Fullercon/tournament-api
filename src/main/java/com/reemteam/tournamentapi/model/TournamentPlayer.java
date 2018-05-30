package com.reemteam.tournamentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="tournament_players")
public class TournamentPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tournamentId;
    private Integer playerId;

    public TournamentPlayer(Integer tournamentId, Integer playerId){
        this.tournamentId = tournamentId;
        this.playerId = playerId;
    }
}
