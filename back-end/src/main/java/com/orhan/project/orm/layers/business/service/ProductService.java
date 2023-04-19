package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CategoryDto;
import com.orhan.project.orm.layers.business.dto.ProductDto;
import com.orhan.project.orm.layers.business.dto.ProductDtoList;
import com.orhan.project.orm.layers.data.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
        void create(ProductDto productDto);
        void update(ProductDto productDto);
        void delete(long productId);
        ProductDtoList list();
        int countByCategory(long categoryId);
        Optional<Product> findById(long productId);

    List<ProductDto> listProductsByCategory(long categoryId);

    List<CategoryDto> listCategories();
    Optional<ProductDto> getProductById(long productId);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    }

