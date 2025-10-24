package com.example.demo.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.domain.Messenger;
import com.example.demo.product.domain.ProductDTO;
import com.example.demo.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public String showSaveForm(Model model) {
        return "product/save";
    }

    @PostMapping("")
    public String save(ProductDTO productDTO, Model model) {
        Messenger result = productService.save(productDTO);
        model.addAttribute("message", result.getMessage());
        model.addAttribute("code", result.getCode());
        model.addAttribute("showAlert", true);
        return "index";
    }

    @PostMapping("/all")
    public String saveAll(List<ProductDTO> productDTO, Model model) {
        Messenger result = productService.saveAll(productDTO);
        model.addAttribute("message", result.getMessage());
        return "product/list";
    }

    @PutMapping("/{id}")
    public String update(ProductDTO productDTO, Model model) {
        Messenger result = productService.update(productDTO);
        model.addAttribute("message", result.getMessage());
        return "product/list";
    }

    @DeleteMapping("/{id}")
    public String delete(ProductDTO productDTO, Model model) {
        Messenger result = productService.delete(productDTO);
        model.addAttribute("message", result.getMessage());
        return "product/list";
    }

    @GetMapping("id/{id}")
    public String findById(String id, Model model) {
        Messenger result = productService.findById(id);
        model.addAttribute("message", result.getMessage());
        return "product/detail";
    }

    @GetMapping("/all")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        Messenger result = productService.findAll();

        // 타입 안전한 캐스팅
        List<ProductDTO> allProducts = new ArrayList<>();
        if (result.getData() instanceof List) {
            @SuppressWarnings("unchecked")
            List<ProductDTO> tempList = (List<ProductDTO>) result.getData();
            allProducts = tempList;
        }

        // 페이지네이션 계산
        int totalProducts = allProducts.size();
        int totalPages = (int) Math.ceil((double) totalProducts / 10);

        // 현재 페이지 유효성 검사
        if (page < 1)
            page = 1;
        if (page > totalPages && totalPages > 0)
            page = totalPages;

        model.addAttribute("message", result.getMessage());
        model.addAttribute("products", allProducts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "product/list";
    }
}
