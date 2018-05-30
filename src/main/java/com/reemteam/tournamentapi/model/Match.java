package com.reemteam.tournamentapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder(toBuilder = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tournamentId;
    private Integer homePlayer;
    private Integer awayPlayer;
    @Enumerated(EnumType.STRING)
    private MatchStatus status;
    private Integer winner;
}
