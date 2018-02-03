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
public class User {
//    @Id
//    @GeneratedValue
    private int id;
    private String email;
    private String password;
    private String username;
    private String avatarFilePath;
}
