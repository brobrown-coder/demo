package com.example.demo.soccer.team.service;

import java.util.List;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.team.domain.TeamDTO;

public interface TeamService {
    Messenger save(TeamDTO teamDTO);

    Messenger update(TeamDTO teamDTO);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    Messenger saveAll(List<TeamDTO> teamDTOs);

    Messenger findByKeyword(String keyword);

}

