package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CartProductDto;

import java.util.List;

public interface CartProductService {
    void addProductToCart(Long cartId, Long productId, int quantity);

    void removeProductFromCart(Long cartId, Long productId);

}

