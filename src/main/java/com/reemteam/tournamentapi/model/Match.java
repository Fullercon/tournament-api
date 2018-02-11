package com.reemteam.tournamentapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder(toBuilder = true)
@Entity
public class Match {
    @Id
    @GeneratedValue
    private int id;
    private int tournamentId;
    private int homePlayer;
    private int awayPlayer;
    private String status;
    private int winner;
}
