package com.example.demo.train.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TrainEntity {

    private String date;
    private String averageTemperature;
    private String maxTemperature;
    private String maxTemperatureTime;
    private String minTemperature;
    private String minTemperatureTime;
    private String dailyTemperatureRange;
    private String precipitation;

}
