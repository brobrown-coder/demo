package com.example.demo.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.example.demo.train.domain.TrainDTO;
import com.example.demo.train.repository.TrainRepository;

import java.util.List;

@Service
public class TrainService implements ApplicationRunner {

    @Autowired
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void processWeatherData(List<TrainDTO> weatherDataList) {
        System.out.println("=== TrainService: 기상 데이터 처리 시작 ===");
        System.out.println("TrainService에서 " + weatherDataList.size() + "개의 레코드를 처리합니다.");

        // Repository로 데이터 전달
        trainRepository.saveWeatherData(weatherDataList);

        System.out.println("=== TrainService: 기상 데이터 처리 완료 ===");
    }

    // 앱 시작 시 자동으로 실행되는 메서드
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=== TrainService: 앱 시작 시 자동 실행 ===");
        trainRepository.loadCsvDataOnStartup();
    }
}
