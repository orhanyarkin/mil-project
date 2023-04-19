package com.orhan.project.orm.layers.business.dto;

import com.orhan.project.orm.layers.data.entity.Product;

public class ProductDto {
    private Long productId;
    private String productName;
    private Double salesPrice;
    private Long categoryId;
    private String categoryName;

    public ProductDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Product toEntity() {
        Product product = new Product();
        product.setProductId(this.productId);
        product.setProductName(this.productName);
        product.setSalesPrice(this.salesPrice);
        return product;
    }

}
