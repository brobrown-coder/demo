package com.example.demo.soccer.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.soccer.schedule.domain.ScheduleDTO;
import com.example.demo.soccer.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Messenger update(ScheduleDTO scheduleDTO) {
        return scheduleRepository.update(scheduleDTO);
    }

    @Override
    public Messenger delete(String id) {
        return scheduleRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Messenger saveAll(List<ScheduleDTO> scheduleDTOs) {
        return scheduleRepository.saveAll(scheduleDTOs);
    }

    @Override
    public Messenger save(ScheduleDTO scheduleDTO) {
        return scheduleRepository.save(scheduleDTO);
    }

}
