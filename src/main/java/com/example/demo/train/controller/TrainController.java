package com.example.demo.train.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.common.domain.Messenger;
import com.example.demo.train.domain.TrainDTO;
import com.example.demo.train.service.TrainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/train")
public class TrainController {
    private final TrainService trainService;

    @PostMapping("")
    public Messenger save(@RequestBody TrainDTO trainDTO) {
        return trainService.save(trainDTO);
    }

    @PutMapping("/{id}")
    public Messenger update(@PathVariable String id, @RequestBody TrainDTO trainDTO) {
        return trainService.update(trainDTO);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(@PathVariable String id, @RequestBody TrainDTO trainDTO) {
        return trainService.delete(trainDTO);
    }

    @GetMapping("/{id}")
    public Messenger findById(@PathVariable String id) {
        return trainService.findById(id);
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        System.out.println("=== TrainController: 기상 데이터 읽기 시작 ===");

        List<TrainDTO> weatherList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/csv/TRAIN_weather.csv-Grid view.csv"))) {

            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                lineCount++;
                System.out.println("읽은 라인 " + lineCount + ": " + line);

                if (lineCount == 1) {
                    continue; // 헤더 라인 스킵
                }

                // 쉼표로 분리하되 빈 값도 포함
                String[] values = line.split(",", -1);
                System.out.println("분리된 컬럼 수: " + values.length);

                if (values.length >= 8) { // 최소 8개 컬럼이면 처리
                    TrainDTO trainDTO = new TrainDTO();
                    trainDTO.setDate(values[0]);
                    trainDTO.setAverageTemperature(values[1]);
                    trainDTO.setMaxTemperature(values[2]);
                    trainDTO.setMaxTemperatureTime(values[3]);
                    trainDTO.setMinTemperature(values[4]);
                    trainDTO.setMinTemperatureTime(values[5]);
                    trainDTO.setDailyTemperatureRange(values[6]);
                    trainDTO.setPrecipitation(values[7]);

                    weatherList.add(trainDTO);
                    System.out.println("DTO 추가됨: " + trainDTO.getDate());
                } else {
                    System.out.println("컬럼 수 부족으로 스킵: " + line);
                }
            }

            System.out.println("총 읽은 라인 수: " + lineCount);
            System.out.println("파싱된 DTO 수: " + weatherList.size());

            // Service를 통해 Repository로 전달하고 Messenger 받기
            Messenger result = trainService.findAll(weatherList);

            // System.out으로 결과 확인
            System.out.println("================================================");
            System.out.println("🎯 TrainController에서 받은 결과:");
            System.out.println("📊 상태 코드: " + result.getCode());
            System.out.println("💬 메시지: " + result.getMessage());
            System.out.println("================================================");

            // Model에 데이터 추가
            model.addAttribute("weatherList", weatherList);
            model.addAttribute("message", result.getMessage());
            model.addAttribute("code", result.getCode());

            return "weather/list";

        } catch (IOException e) {
            System.out.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            System.out.println("❌ 오류 상세: " + e.getMessage());

            // 오류 시 빈 리스트와 오류 메시지 전달
            model.addAttribute("weatherList", new ArrayList<>());
            model.addAttribute("message", "CSV 파일 읽기 오류: " + e.getMessage());
            model.addAttribute("code", 500);

            return "weather/list";
        }
    }
}
