package com.reemteam.tournamentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TournamentType type;
    private Integer matchesRemaining;
    private Integer winner;
    private Integer homeAwaysEach;
    private Date startDate;
    private Date endDate;
    private Integer createdPlayer;

    @Transient
    private List<Integer> players;
}
