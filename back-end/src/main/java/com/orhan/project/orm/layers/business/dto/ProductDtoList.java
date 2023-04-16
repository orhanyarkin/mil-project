package com.orhan.project.orm.layers.business.dto;

import java.util.List;

public class ProductDtoList {
    private int productCount;
    private long categoryId;
    private String categoryName;

    private List<ProductDto> productDtoList;

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductDto> getProductDetailList() {
        return productDtoList;
    }

    public void setProductDetailList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }
    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

}
