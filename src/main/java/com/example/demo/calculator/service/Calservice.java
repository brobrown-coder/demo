package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;
import com.example.demo.calculator.domain.CalDTO;

@Service
public class Calservice {

    public double calculate(CalDTO calDTO) {
        System.out.println("=== 계산기 서비스에서 받은 데이터 ===");
        System.out.println("첫 번째 숫자: " + calDTO.getFirstNumber());
        System.out.println("연산자: " + calDTO.getOperator());
        System.out.println("두 번째 숫자: " + calDTO.getSecondNumber());
        System.out.println("================================");

        // String을 double로 변환
        double firstNum = Double.parseDouble(calDTO.getFirstNumber());
        double secondNum = Double.parseDouble(calDTO.getSecondNumber());
        String operator = calDTO.getOperator();

        double result = 0;

        // 연산자에 따른 계산 수행
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                System.out.println("덧셈 연산 수행: " + firstNum + " + " + secondNum + " = " + result);
                break;
            case "-":
                result = firstNum - secondNum;
                System.out.println("뺄셈 연산 수행: " + firstNum + " - " + secondNum + " = " + result);
                break;
            case "*":
                result = firstNum * secondNum;
                System.out.println("곱셈 연산 수행: " + firstNum + " * " + secondNum + " = " + result);
                break;
            case "/":
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                    System.out.println("나눗셈 연산 수행: " + firstNum + " / " + secondNum + " = " + result);
                } else {
                    System.out.println("오류: 0으로 나눌 수 없습니다!");
                    return Double.NaN; // Not a Number 반환
                }
                break;
            default:
                System.out.println("지원하지 않는 연산자입니다: " + operator);
                return Double.NaN; // Not a Number 반환
        }

        System.out.println("=== 최종 계산 결과 ===");
        System.out.println("결과: " + result);
        System.out.println("===================");

        return result; // 계산된 결과 반환
    }
}
