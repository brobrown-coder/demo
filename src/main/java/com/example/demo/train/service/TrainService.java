package com.example.demo.train.service;

import java.util.List;

import com.example.demo.common.domain.Messenger;
import com.example.demo.train.domain.TrainDTO;

public interface TrainService {

    Messenger save(TrainDTO trainDTO);

    Messenger update(TrainDTO trainDTO);

    Messenger delete(TrainDTO trainDTO);

    Messenger findById(String id);

    Messenger findAll();

    Messenger findAll(List<TrainDTO> weatherList);

}
