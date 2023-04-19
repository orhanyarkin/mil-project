package com.orhan.project.orm.layers.business.dto;

import java.util.List;

public class CartDto {

    private Long id;
    private List<CartProductDto> cartProducts;
    public CartDto(){

    }

    public CartDto(Long id, List<CartProductDto> cartProducts) {
        this.id = id;
        this.cartProducts = cartProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartProductDto> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProductDto> cartProducts) {
        this.cartProducts = cartProducts;
    }
}


