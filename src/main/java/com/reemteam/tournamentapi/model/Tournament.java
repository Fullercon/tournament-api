package com.reemteam.tournamentapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tournament {
    private int id;
    private String name;
    private String type;
    private List<User> players;
    private List<Match> matches;
    private int matchesRemaining;
    private User winner;
    private Date startDate;
    private Date endDate;
    private User createdUser;
}
