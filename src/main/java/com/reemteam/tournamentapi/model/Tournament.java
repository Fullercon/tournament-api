package com.reemteam.tournamentapi.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder(toBuilder = true)
@Entity
public class Tournament {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;
    private int matchesRemaining;
    private int winner;
    private Date startDate;
    private Date endDate;
    private int createdPlayer;
}
