package com.example.demo.calculator.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.calculator.domain.CalDTO;
import com.example.demo.calculator.service.Calservice;

@Repository
public class CalculatorRepository implements Calservice {

    @Override
    public int add(CalDTO calDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int sub(CalDTO calDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sub'");
    }

    @Override
    public int mul(CalDTO calDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mul'");
    }

    @Override
    public int div(CalDTO calDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'div'");
    }

}
