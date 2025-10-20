package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Controller
@Order(1)
public class RegisterController implements CommandLineRunner {

    // 승객 정보를 담을 내부 클래스
    public static class Passenger {
        private String id;
        private String survived;
        private String pclass;
        private String name;
        private String sex;
        private String age;
        private String sibSp;
        private String parch;
        private String ticket;
        private String fare;
        private String cabin;
        private String embarked;

        public Passenger(Map<String, String> data) {
            this.id = data.get("PassengerId");
            this.survived = data.get("Survived");
            this.pclass = data.get("Pclass");
            this.name = data.get("Name");
            this.sex = data.get("Sex");
            this.age = data.get("Age");
            this.sibSp = data.get("SibSp");
            this.parch = data.get("Parch");
            this.ticket = data.get("Ticket");
            this.fare = data.get("Fare");
            this.cabin = data.get("Cabin");
            this.embarked = data.get("Embarked");
        }

        @Override
        public String toString() {
            return String.format(
                    "승객 정보:\n" +
                            "  ID: %s\n" +
                            "  생존: %s\n" +
                            "  등급: %s\n" +
                            "  이름: %s\n" +
                            "  성별: %s\n" +
                            "  나이: %s\n" +
                            "  형제자매/배우자: %s\n" +
                            "  부모/자녀: %s\n" +
                            "  티켓: %s\n" +
                            "  요금: %s\n" +
                            "  객실: %s\n" +
                            "  탑승항: %s\n" +
                            "  -------------------------",
                    id,
                    survived.equals("1") ? "생존" : "사망",
                    pclass, name, sex, age, sibSp, parch, ticket, fare, cabin, embarked);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        printTop5Passengers();
    }

    public void printTop5Passengers() {
        try {
            // CSV 파일에서 데이터 읽기
            List<Passenger> passengers = readPassengerData();

            System.out.println("=== Titanic 승객 데이터 (상위 5명) ===");
            System.out.println();

            // 상위 5명만 출력
            passengers.stream()
                    .limit(5)
                    .forEach(passenger -> {
                        System.out.println(passenger);
                        System.out.println();
                    });

            // 통계 정보 출력
            printStatistics(passengers);

        } catch (IOException e) {
            System.err.println("CSV 파일 읽기 오류: " + e.getMessage());
        }
    }

    private List<Passenger> readPassengerData() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/csv/train.csv");
        List<Passenger> passengers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            // 헤더 읽기
            String headerLine = reader.readLine();
            String[] headers = parseCSVLine(headerLine);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = parseCSVLine(line);
                Map<String, String> passengerData = createPassengerMap(headers, values);
                passengers.add(new Passenger(passengerData));
            }
        }

        return passengers;
    }

    private Map<String, String> createPassengerMap(String[] headers, String[] values) {
        Map<String, String> passengerMap = new LinkedHashMap<>();

        for (int i = 0; i < headers.length && i < values.length; i++) {
            String key = headers[i].replaceAll("\"", "").trim();
            String value = values[i].replaceAll("\"", "").trim();
            passengerMap.put(key, value);
        }

        return passengerMap;
    }

    private void printStatistics(List<Passenger> passengers) {
        System.out.println("=== 통계 정보 ===");

        // 생존자 통계
        long survivedCount = passengers.stream()
                .mapToInt(p -> p.survived.equals("1") ? 1 : 0)
                .sum();

        System.out.println("전체 승객 수: " + passengers.size());
        System.out.println("생존자 수: " + survivedCount);
        System.out.println("사망자 수: " + (passengers.size() - survivedCount));
        System.out.println("생존률: " + String.format("%.2f%%", (double) survivedCount / passengers.size() * 100));

        // 등급별 통계
        Map<String, Long> classStats = passengers.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        p -> "등급 " + p.pclass,
                        java.util.stream.Collectors.counting()));

        System.out.println("\n등급별 승객 수:");
        classStats.forEach((key, value) -> System.out.println("  " + key + ": " + value + "명"));

        // 성별 통계
        Map<String, Long> genderStats = passengers.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        p -> p.sex.equals("male") ? "남성" : "여성",
                        java.util.stream.Collectors.counting()));

        System.out.println("\n성별 승객 수:");
        genderStats.forEach((key, value) -> System.out.println("  " + key + ": " + value + "명"));
    }

    private String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(current.toString().trim());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        result.add(current.toString().trim());

        return result.toArray(new String[0]);
    }
}