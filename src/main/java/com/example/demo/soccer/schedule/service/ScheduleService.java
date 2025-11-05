package com.example.demo.soccer.schedule.service;

import java.util.List;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.schedule.domain.ScheduleDTO;

public interface ScheduleService {
    Messenger save(ScheduleDTO scheduleDTO);

    Messenger update(ScheduleDTO scheduleDTO);

    Messenger delete(String id);

    Messenger findById(String id);

    Messenger findAll();

    Messenger saveAll(List<ScheduleDTO> scheduleDTOs);

}


