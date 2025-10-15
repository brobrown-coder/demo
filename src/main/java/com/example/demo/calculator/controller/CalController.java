package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.calculator.service.Calservice;
import com.example.demo.calculator.domain.CalDTO;

@Controller
public class CalController {
    
    private final Calservice calservice;

    public CalController(Calservice calservice) {
        this.calservice = calservice;
    }

    @GetMapping("/calculate")
    @ResponseBody
    public void calculate(@RequestParam("firstNumber") String firstNumber, 
                         @RequestParam("operator") String operator, 
                         @RequestParam("secondNumber") String secondNumber) {
        System.out.println("=== 화면에서 컨트롤러도 전달한 파라미터 ===");
        System.out.println("첫 번째 숫자: " + firstNumber);
        System.out.println("연산자: " + operator);
        System.out.println("두 번째 숫자: " + secondNumber);
        System.out.println("================================");
        
        // CalDTO 객체 생성하여 서비스로 전달
        CalDTO calDTO = new CalDTO(firstNumber, operator, secondNumber);
        calservice.calculate(calDTO);
    }
}
