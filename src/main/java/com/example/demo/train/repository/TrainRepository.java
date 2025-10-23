package com.example.demo.train.repository;

import com.example.demo.common.domain.Messenger;
import com.example.demo.train.domain.TrainDTO;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TrainRepository {

    public Messenger save(TrainDTO trainDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Messenger update(TrainDTO trainDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Messenger delete(TrainDTO trainDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Messenger findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Messenger findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Messenger findAll(List<TrainDTO> weatherDataList) {
        System.out.println("=== TrainRepository: 기상 데이터 저장 시작 ===");
        System.out.println("총 " + weatherDataList.size() + "개의 레코드가 저장됩니다.");
        System.out.println("================================================");

        for (int i = 0; i < weatherDataList.size(); i++) {
            TrainDTO data = weatherDataList.get(i);
            System.out.println("--- 레코드 " + (i + 1) + " ---");
            System.out.println("일시: " + data.getDate());
            System.out.println("평균기온: " + data.getAverageTemperature() + "℃");
            System.out.println("최고기온: " + data.getMaxTemperature() + "℃");
            System.out.println("최고기온시각: " + data.getMaxTemperatureTime());
            System.out.println("최저기온: " + data.getMinTemperature() + "℃");
            System.out.println("최저기온시각: " + data.getMinTemperatureTime());
            System.out.println("일교차: " + data.getDailyTemperatureRange() + "℃");
            System.out.println("강수량: " + data.getPrecipitation() + "mm");
            System.out.println("----------------------------------------");
        }

        System.out.println("=== TrainRepository: 기상 데이터 저장 완료 ===");
        System.out.println("총 " + weatherDataList.size() + "건의 데이터가 성공적으로 저장되었습니다.");

        // 성공 시 Messenger에 담아서 리턴
        Messenger messenger = new Messenger();
        messenger.setMessage("기상 데이터 저장 성공 - 총 " + weatherDataList.size() + "건 처리됨");
        messenger.setCode(200);
        return messenger;
    }

}
