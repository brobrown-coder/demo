package com.example.demo.soccer.player.domain;

import com.example.demo.soccer.team.domain.Team;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "player")
@Data
public class Player {

    @Id
    private Long playerId;

    private String playerName;

    private String ePlayerName;

    private String nickname;

    private String joinYyyy;

    private String position;

    private String backNo;

    private String nation;

    private String birthDate;

    private String solar;

    private String height;

    private String weight;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
