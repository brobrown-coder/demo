package com.example.demo.train.domain;

import lombok.Getter;

@Getter
public class TrainVO {
    private String averageTemperature;
    private String maxTemperature;
    private String maxTemperatureTime;
    private String minTemperature;
    private String minTemperatureTime;
    private String dailyTemperatureRange;
    private String precipitation;
}
