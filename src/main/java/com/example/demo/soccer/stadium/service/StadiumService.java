package com.example.demo.soccer.stadium.service;

import java.util.List;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.stadium.domain.StadiumDTO;

public interface StadiumService {
    Messenger save(StadiumDTO stadiumDTO);

    Messenger update(StadiumDTO stadiumDTO);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    Messenger saveAll(List<StadiumDTO> stadiumDTOs);

    Messenger findByKeyword(String keyword);

}

