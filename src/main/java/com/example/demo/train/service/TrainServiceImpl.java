package com.example.demo.train.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.train.domain.TrainDTO;
import com.example.demo.train.repository.TrainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    @Override
    public Messenger save(TrainDTO trainDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Messenger update(TrainDTO trainDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Messenger delete(TrainDTO trainDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Messenger findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Messenger findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Messenger findAll(List<TrainDTO> weatherList) {
        System.out.println("=== TrainService: 기상 데이터 처리 시작 ===");
        System.out.println("Service에서 " + weatherList.size() + "개의 레코드를 처리합니다.");

        // Repository로 데이터 전달
        Messenger result = trainRepository.findAll(weatherList);

        System.out.println("=== TrainService: 기상 데이터 처리 완료 ===");
        return result;
    }

}
