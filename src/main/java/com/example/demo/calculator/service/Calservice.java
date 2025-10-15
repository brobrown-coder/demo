package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;
import com.example.demo.calculator.domain.CalDTO;

@Service
public class Calservice {
    
    public void calculate(CalDTO calDTO) {
        System.out.println("=== 계산기 서비스에서 받은 데이터 ===");
        System.out.println("첫 번째 숫자: " + calDTO.getFirstNumber());
        System.out.println("연산자: " + calDTO.getOperator());
        System.out.println("두 번째 숫자: " + calDTO.getSecondNumber());
        System.out.println("================================");
    }
}
