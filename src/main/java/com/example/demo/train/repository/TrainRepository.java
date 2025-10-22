package com.example.demo.train.repository;

import com.example.demo.train.domain.TrainDTO;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainRepository {

    public void saveWeatherData(List<TrainDTO> weatherDataList) {
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
        System.out.println("총 " + weatherDataList.size() + "건의 데이터가 성공적으로 출력되었습니다.");
    }

    // 앱 시작 시 자동으로 실행되는 메서드
    public void loadCsvDataOnStartup() {
        System.out.println("=== 앱 시작: CSV 데이터 자동 로드 ===");

        List<TrainDTO> weatherDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/csv/TRAIN_weather.csv-Grid view.csv"))) {
            String line;
            boolean isFirstLine = true;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                lineCount++;
                System.out.println("읽은 라인 " + lineCount + ": " + line);

                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 헤더 라인 스킵
                }

                // 쉼표로 분리하되 빈 값도 포함
                String[] values = line.split(",", -1);
                System.out.println("분리된 컬럼 수: " + values.length);

                if (values.length >= 7) { // 최소 7개 컬럼이면 처리
                    TrainDTO trainDTO = new TrainDTO();
                    trainDTO.setDate(values[0]);
                    trainDTO.setAverageTemperature(values[1]);
                    trainDTO.setMaxTemperature(values[2]);
                    trainDTO.setMaxTemperatureTime(values[3]);
                    trainDTO.setMinTemperature(values[4]);
                    trainDTO.setMinTemperatureTime(values[5]);
                    trainDTO.setDailyTemperatureRange(values[6]);
                    trainDTO.setPrecipitation(values.length > 7 ? values[7] : "");

                    weatherDataList.add(trainDTO);
                    System.out.println("DTO 추가됨: " + trainDTO.getDate());
                } else {
                    System.out.println("컬럼 수 부족으로 스킵: " + line);
                }
            }

            System.out.println("총 읽은 라인 수: " + lineCount);
            System.out.println("파싱된 DTO 수: " + weatherDataList.size());

            // 데이터 저장 및 출력
            saveWeatherData(weatherDataList);

        } catch (IOException e) {
            System.out.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
