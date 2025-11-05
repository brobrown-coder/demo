package com.example.demo.soccer.schedule.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.schedule.domain.ScheduleDTO;

@Repository
public class ScheduleRepository {

    public Messenger save(ScheduleDTO scheduleDTO) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

    public Messenger update(ScheduleDTO scheduleDTO) {
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

    public Messenger saveAll(List<ScheduleDTO> scheduleDTOs) {
        return Messenger.builder()
                .code(200)
                .message("success")
                .build();
    }

}
