package com.reemteam.tournamentapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Match {
//    @Id
//    @GeneratedValue
    private int id;
    private int tournamentId;
    private User homePlayer;
    private User awayPlayer;
    private String status;
    private User winner;
}
