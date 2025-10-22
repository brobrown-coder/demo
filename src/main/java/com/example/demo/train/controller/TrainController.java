package com.example.demo.train.controller;

import com.example.demo.train.domain.TrainDTO;
import com.example.demo.train.service.TrainService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/train")
@RequiredArgsConstructor
public class TrainController {

    private TrainService trainService;

    @GetMapping("/load-csv")
    public String loadCsvData(Model model) {
        List<TrainDTO> weatherDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/csv/TRAIN_weather.csv-Grid view.csv"))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 헤더 라인 스킵
                }

                String[] values = line.split(",");
                if (values.length >= 8) {
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
                }
            }

            // TrainService를 통해 데이터 처리
            trainService.processWeatherData(weatherDataList);

            model.addAttribute("message", "CSV 데이터가 성공적으로 로드되었습니다. 총 " + weatherDataList.size() + "개의 레코드가 파싱되었습니다.");
            model.addAttribute("weatherData", weatherDataList);

        } catch (IOException e) {
            model.addAttribute("message", "CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }

        return "result"; // 결과 페이지로 이동
    }

}
