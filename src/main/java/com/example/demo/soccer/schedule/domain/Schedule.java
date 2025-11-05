package com.example.demo.soccer.schedule.domain;

import com.example.demo.soccer.stadium.domain.Stadium;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "schedule")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scheDate;

    @Column(name = "stadium_id")
    private String stadiumUk;

    @ManyToOne
    @JoinColumn(name = "stadium_id", insertable = false, updatable = false)
    private Stadium stadium;

    private String gubun;

    private String hometeamId;

    private String awayteamId;

    private Integer homeScore;

    private Integer awayScore;

}
