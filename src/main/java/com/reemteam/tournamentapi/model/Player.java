package com.reemteam.tournamentapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder(toBuilder = true)
@Entity
public class Player {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;
    private String username;
    private String avatarFilePath;
}
