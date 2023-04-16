package com.orhan.project.orm.layers.presentation.rest;

import com.orhan.project.orm.layers.business.dto.ProductDto;
import com.orhan.project.orm.layers.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{categoryId}")
    public List<ProductDto> listProductsByCategory(@PathVariable("categoryId") long categoryId) {
        return productService.listProductsByCategory(categoryId);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long id) {
        Optional<ProductDto> optionalProductDto = productService.getProductById(id);
        return optionalProductDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}