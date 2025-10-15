package com.example.demo.calculator.domain;

public class CalDTO {
    private String firstNumber;  // 첫 번째 숫자 (예: "5")
    private String operator;     // 연산자 (예: "+")
    private String secondNumber; // 두 번째 숫자 (예: "3")

    // 기본 생성자
    public CalDTO() {}

    // 생성자
    public CalDTO(String firstNumber, String operator, String secondNumber) {
        this.firstNumber = firstNumber;
        this.operator = operator;
        this.secondNumber = secondNumber;
    }

    // Getters and Setters
    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }
}
