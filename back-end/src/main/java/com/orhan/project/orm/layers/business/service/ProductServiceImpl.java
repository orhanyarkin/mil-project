package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CategoryDto;
import com.orhan.project.orm.layers.business.dto.ProductDto;
import com.orhan.project.orm.layers.business.dto.ProductDtoList;
import com.orhan.project.orm.layers.data.entity.Category;
import com.orhan.project.orm.layers.data.entity.Product;
import com.orhan.project.orm.layers.data.repository.CategoryRepository;
import com.orhan.project.orm.layers.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(ProductDto productDto) {
        Product product=toEntity(productDto);
        productRepository.save(product);
        product.setProductId(product.getProductId());
    }

    @Override
    public void update(ProductDto productDto) {
        Product product=toEntity(productDto);
        productRepository.save(product);
    }

    @Override
    public void delete(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDtoList list() {
        ProductDtoList productDtoList=new ProductDtoList();
        productDtoList.setProductDetailList(new ArrayList<>());
        for(Product product : productRepository.findAll()){
            ProductDto productDto=toDto(product);
            productDtoList.getProductDetailList().add(productDto);
        }
        return productDtoList;
    }
    @Override
    public List<ProductDto> listProductsByCategory(long categoryId) {
        List<ProductDto> productDtoList = new ArrayList<>();
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            for (Product product : productRepository.findByCategory(category.get().getCategoryId())) {
                productDtoList.add(toDto(product));
            }
        }
        return productDtoList;
    }

    @Override
    public List<CategoryDto> listCategories() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
    @Override
    public int countByCategory(long categoryId) {
        return productRepository.countByCategory(categoryId);
    }

    @Override
    public Optional<Product> findById(long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Optional<ProductDto> getProductById(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return Optional.of(toDto(product.get()));
        }
        return Optional.empty();
    }
    private Product toEntity(ProductDto productDto){
    Product product=new Product();
    product.setProductId(productDto.getProductId());
    product.setProductName(productDto.getProductName());
    product.setSalesPrice(productDto.getSalesPrice());
    if(productDto.getCategoryId()!=0) {
        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if (category.isPresent()) {
            product.setCategory(category.get());
        }
    }
    return product;
    }
    private ProductDto toDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        if(product.getCategory()!=null){
            productDto.setCategoryId(product.getCategory().getCategoryId());
            productDto.setCategoryName(product.getCategory().getCategoryName());
        }
        return productDto;
    }
}
