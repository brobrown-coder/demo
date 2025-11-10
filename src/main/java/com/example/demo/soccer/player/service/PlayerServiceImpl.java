package com.example.demo.soccer.player.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.player.domain.PlayerDTO;
import com.example.demo.soccer.player.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public Messenger update(PlayerDTO playerDTO) {
        return playerRepository.update(playerDTO);
    }

    @Override
    public Messenger delete(String id) {
        return playerRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return playerRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Messenger saveAll(List<PlayerDTO> playerDTOs) {
        return playerRepository.saveAll(playerDTOs);
    }

    @Override
    public Messenger save(PlayerDTO playerDTO) {
        return playerRepository.save(playerDTO);
    }

    @Override
    public Messenger findByKeyword(String keyword) {
        return playerRepository.findByKeyword(keyword);
    }

}
