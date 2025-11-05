package com.example.demo.soccer.stadium.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.stadium.domain.StadiumDTO;

@Repository
public class StadiumRepository {

    public Messenger save(StadiumDTO stadiumDTO) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

    public Messenger update(StadiumDTO stadiumDTO) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

    public Messenger delete(String id) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

    public Messenger findById(String id) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

    public Messenger findAll() {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

    public Messenger saveAll(List<StadiumDTO> stadiumDTOs) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

}

