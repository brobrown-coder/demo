package com.example.demo.product.service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.product.domain.ProductDTO;
import java.util.List;

public interface ProductService {

    Messenger save(ProductDTO productDTO);

    Messenger saveAll(List<ProductDTO> productDTOs);

    Messenger update(ProductDTO productDTO);

    Messenger delete(ProductDTO productDTO);

    Messenger findById(String id);

    Messenger findAll();

}
