package com.example.demo.product.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.common.domain.Messenger;
import com.example.demo.product.domain.ProductDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    public Messenger save(ProductDTO productDTO) {
        System.out.println("=== ProductRepository: 상품 저장 요청 ===");
        System.out.println("상품명: " + productDTO.getName());

        Messenger messenger = new Messenger();
        messenger.setMessage("Product saved successfully");
        messenger.setCode(200);
        return messenger;
    }

    public Messenger saveAll(List<ProductDTO> productDTOs) {
        Messenger messenger = new Messenger();
        messenger.setMessage("Products saved successfully");
        messenger.setCode(200);
        return messenger;
    }

    public Messenger update(ProductDTO productDTO) {
        Messenger messenger = new Messenger();
        messenger.setMessage("Product updated successfully");
        messenger.setCode(200);
        return messenger;
    }

    public Messenger delete(ProductDTO productDTO) {
        Messenger messenger = new Messenger();
        messenger.setMessage("Product deleted successfully");
        messenger.setCode(200);
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setMessage("Product found successfully");
        messenger.setCode(200);
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setMessage("Products found successfully");
        messenger.setCode(200);
        return messenger;
    }

}
