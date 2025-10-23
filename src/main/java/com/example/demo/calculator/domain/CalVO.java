package com.example.demo.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CalVO {
    
    private String firstNumber; // 첫 번째 숫자 (예: "5")
    private String operator; // 연산자 (예: "+")
    private String secondNumber; // 두 번째 숫자 (예: "3")
}
