package com.example.demo.user.repository;

import com.example.demo.user.domain.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public void print(List<UserDTO> passengers) {
        System.out.println("=== Titanic 승객 데이터 (상위 5명) ===");
        System.out.println();

        passengers.forEach(p -> {
            System.out.println("승객 정보:");
            System.out.println("  ID: " + p.getPassengerId());
            System.out.println("  생존: " + ("1".equals(p.getSurvived()) ? "생존" : "사망"));
            System.out.println("  등급: " + p.getPclass());
            System.out.println("  이름: " + p.getName());
            System.out.println("  성별: " + p.getGender());
            System.out.println("  나이: " + p.getAge());
            System.out.println("  형제자매/배우자: " + p.getSibSp());
            System.out.println("  부모/자녀: " + p.getParch());
            System.out.println("  티켓: " + p.getTicket());
            System.out.println("  요금: " + p.getFare());
            System.out.println("  객실: " + p.getCabin());
            System.out.println("  탑승항: " + p.getEmbarked());
            System.out.println("  -------------------------");
            System.out.println();
        });
    }

}
