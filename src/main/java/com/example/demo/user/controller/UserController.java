package com.example.demo.user.controller;

import com.example.demo.common.domain.Messenger;
import com.example.demo.user.domain.UserDTO;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public Messenger save(@RequestBody UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @PutMapping("/{id}")
    public Messenger update(@RequestBody UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @DeleteMapping("/{id}")
    public Messenger delete(@RequestBody UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @GetMapping("/id/{id}")
    public Messenger findById(@PathVariable String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @GetMapping("/all")
    public Messenger findAll(@PathVariable String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @GetMapping("/saveall")
    public String saveAll(Model model) {
        System.out.println("=== UserController: CSV 데이터 읽기 시작 ===");

        List<UserDTO> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/csv/train.csv"))) {

            String line;
            int lineCount = 0;
            int dataCount = 0;

            while ((line = br.readLine()) != null && dataCount < 5) {
                lineCount++;
                System.out.println("읽은 라인 " + lineCount + ": " + line);

                if (lineCount == 1) {
                    continue; // 헤더 라인 스킵
                }

                // 쉼표로 분리하되 빈 값도 포함
                String[] values = line.split(",", -1);
                System.out.println("분리된 컬럼 수: " + values.length);

                if (values.length >= 12) { // 최소 12개 컬럼이면 처리
                    UserDTO userDTO = new UserDTO();
                    userDTO.setPassengerId(values[0]);
                    userDTO.setSurvived(values[1]);
                    userDTO.setPclass(values[2]);
                    userDTO.setName(values[3]);
                    userDTO.setGender(values[4]);
                    userDTO.setAge(values[5]);
                    userDTO.setSibSp(values[6]);
                    userDTO.setParch(values[7]);
                    userDTO.setTicket(values[8]);
                    userDTO.setFare(values[9]);
                    userDTO.setCabin(values[10]);
                    userDTO.setEmbarked(values[11]);

                    userList.add(userDTO);
                    dataCount++;
                    System.out.println("DTO 추가됨: " + userDTO.getName());
                } else {
                    System.out.println("컬럼 수 부족으로 스킵: " + line);
                }
            }

            System.out.println("총 읽은 라인 수: " + lineCount);
            System.out.println("파싱된 DTO 수: " + userList.size());

            // Service를 통해 Repository로 전달하고 결과 받기
            Messenger result = userService.saveAll(userList);

            // System.out으로 결과 확인
            System.out.println("================================================");
            System.out.println("🎯 UserController에서 받은 결과:");
            System.out.println("📊 상태 코드: " + result.getCode());
            System.out.println("💬 메시지: " + result.getMessage());
            System.out.println("================================================");

            // Model에 데이터 추가
            model.addAttribute("userList", userList);
            model.addAttribute("message", result.getMessage());

            return "user/list";

        } catch (IOException e) {
            System.out.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            model.addAttribute("userList", new ArrayList<>());
            model.addAttribute("message", "CSV 파일 읽기 오류: " + e.getMessage());
            return "user/list";
        }
    }
}