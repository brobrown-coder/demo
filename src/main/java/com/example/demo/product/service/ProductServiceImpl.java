package com.example.demo.product.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.product.domain.ProductDTO;
import com.example.demo.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Messenger save(ProductDTO productDTO) {
        System.out.println("=== ProductService: 상품 저장 시작 ===");
        System.out.println("상품명: " + productDTO.getName());
        System.out.println("브랜드: " + productDTO.getBrand());
        System.out.println("가격: " + productDTO.getPrice());

        try {
            // CSV 파일에 새 상품 추가
            ClassPathResource resource = new ClassPathResource("static/csv/products-100.csv");
            List<String> lines = new ArrayList<>();

            // 기존 CSV 파일 읽기
            try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            // 새로운 상품 데이터 생성 (첫 번째 항목으로 추가)
            String newProductLine = createProductLine(productDTO, lines.size());

            // 첫 번째 데이터 행 앞에 새 상품 삽입
            lines.add(1, newProductLine);

            // CSV 파일에 쓰기
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resource.getFile()))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }

            System.out.println("=== ProductService: 상품 저장 완료 ===");
            System.out.println("새 상품이 CSV 파일에 추가되었습니다.");

            Messenger messenger = new Messenger();
            messenger.setMessage("상품이 성공적으로 저장되었습니다");
            messenger.setCode(200);
            return messenger;

        } catch (IOException e) {
            System.out.println("=== ProductService: 상품 저장 오류 ===");
            System.out.println("오류 메시지: " + e.getMessage());

            Messenger messenger = new Messenger();
            messenger.setMessage("상품 저장 중 오류가 발생했습니다: " + e.getMessage());
            messenger.setCode(500);
            return messenger;
        }
    }

    private String createProductLine(ProductDTO productDTO, int currentIndex) {
        // CSV 형식으로 상품 데이터 생성
        StringBuilder sb = new StringBuilder();
        sb.append(currentIndex).append(","); // Index
        sb.append(escapeCsv(productDTO.getName())).append(","); // Name
        sb.append(escapeCsv(productDTO.getDescription())).append(","); // Description
        sb.append(escapeCsv(productDTO.getBrand())).append(","); // Brand
        sb.append(escapeCsv(productDTO.getCategory())).append(","); // Category
        sb.append(productDTO.getPrice()).append(","); // Price
        sb.append(escapeCsv(productDTO.getCurrency())).append(","); // Currency
        sb.append(productDTO.getStock()).append(","); // Stock
        sb.append(escapeCsv(productDTO.getEan())).append(","); // EAN
        sb.append(escapeCsv(productDTO.getColor())).append(","); // Color
        sb.append(escapeCsv(productDTO.getSize())).append(","); // Size
        sb.append(escapeCsv(productDTO.getAvailability())).append(","); // Availability
        sb.append(escapeCsv(productDTO.getInternalId())); // Internal ID

        return sb.toString();
    }

    private String escapeCsv(String value) {
        if (value == null) {
            return "";
        }
        // CSV에서 쉼표나 따옴표가 포함된 경우 따옴표로 감싸기
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }

    @Override
    public Messenger saveAll(List<ProductDTO> productDTOs) {
        return productRepository.saveAll(productDTOs);
    }

    @Override
    public Messenger update(ProductDTO productDTO) {
        return productRepository.update(productDTO);
    }

    @Override
    public Messenger delete(ProductDTO productDTO) {
        return productRepository.delete(productDTO);
    }

    @Override
    public Messenger findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        System.out.println("=== ProductService: CSV 파일 읽기 시작 ===");
        Messenger messenger = new Messenger();
        List<ProductDTO> products = new ArrayList<>();

        try {
            // CSV 파일 경로
            ClassPathResource resource = new ClassPathResource("static/csv/products-100.csv");

            try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
                String line;
                boolean isFirstLine = true;

                while ((line = br.readLine()) != null) {
                    // 첫 번째 줄(헤더) 건너뛰기
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }

                    // 빈 줄 건너뛰기
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    String[] values = line.split(",");

                    // CSV 컬럼이 13개인지 확인
                    if (values.length >= 13) {
                        ProductDTO product = new ProductDTO();
                        product.setIndex(values[0].trim());
                        product.setName(values[1].trim());
                        product.setDescription(values[2].trim());
                        product.setBrand(values[3].trim());
                        product.setCategory(values[4].trim());
                        product.setPrice(values[5].trim());
                        product.setCurrency(values[6].trim());
                        product.setStock(values[7].trim());
                        product.setEan(values[8].trim());
                        product.setColor(values[9].trim());
                        product.setSize(values[10].trim());
                        product.setAvailability(values[11].trim());
                        product.setInternalId(values[12].trim());

                        products.add(product);
                    }
                }
            }

            messenger.setMessage("Products loaded successfully from CSV - 총 " + products.size() + "개 상품");
            messenger.setCode(200);
            messenger.setData(products);
            System.out.println("=== ProductService: CSV 파일 읽기 완료 - " + products.size() + "개 상품 ===");

        } catch (IOException e) {
            System.out.println("=== ProductService: CSV 파일 읽기 오류 ===");
            System.out.println("오류 메시지: " + e.getMessage());
            messenger.setMessage("Error reading CSV file: " + e.getMessage());
            messenger.setCode(500);
            messenger.setData(new ArrayList<>());
        }

        return messenger;
    }

}
