package com.example.demo.user.service;

import com.example.demo.user.domain.UserDTO;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void printPassengers(List<UserDTO> passengers) {
        userRepository.print(passengers);
    }

}
