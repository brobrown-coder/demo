package com.example.demo.soccer.player.service;

import java.util.List;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.player.domain.PlayerDTO;

public interface PlayerService {
    Messenger save(PlayerDTO playerDTO);

    Messenger update(PlayerDTO playerDTO);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    Messenger saveAll(List<PlayerDTO> playerDTOs);

}
