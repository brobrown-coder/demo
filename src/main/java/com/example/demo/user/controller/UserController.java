package com.example.demo.user.controller;

import com.example.demo.user.domain.UserDTO;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/top5")
    public void getTop5() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ClassPathResource("static/csv/train.csv").getInputStream()))) {

            reader.readLine(); // 헤더 스킵
            List<UserDTO> users = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                String[] values = parseLine(reader.readLine());
                users.add(new UserDTO(values[0], values[1], values[2], values[3],
                        values[4], values[5], values[6], values[7], values[8],
                        values[9], values[10], values[11]));
            }

            // System.out.println("\n========== [CONTROLLER 단] DTO 확인 ==========");
            // users.forEach(user -> System.out.println("[CONTROLLER] " + user));
            // System.out.println("============================================\n");

            userService.printPassengers(users);
        }
    }

    private String[] parseLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"')
                inQuotes = !inQuotes;
            else if (c == ',' && !inQuotes) {
                result.add(current.toString().replaceAll("\"", "").trim());
                current = new StringBuilder();
            } else
                current.append(c);
        }
        result.add(current.toString().replaceAll("\"", "").trim());
        return result.toArray(new String[0]);
    }
}