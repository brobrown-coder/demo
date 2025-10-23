package com.example.demo.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalDTO {
    private String firstNumber; // 첫 번째 숫자 (예: "5")
    private String operator; // 연산자 (예: "+")
    private String secondNumber; // 두 번째 숫자 (예: "3")

}
