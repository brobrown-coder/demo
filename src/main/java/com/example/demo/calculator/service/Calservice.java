package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

import com.example.demo.calculator.domain.CalDTO;

@Service
public interface Calservice {

    public int add(CalDTO calDTO);

    public int sub(CalDTO calDTO);

    public int mul(CalDTO calDTO);

    public int div(CalDTO calDTO);

}
