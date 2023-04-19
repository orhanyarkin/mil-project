package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CartDto;

public interface CartService {
    CartDto getCartById(Long cartId);
    void addProductToCart(Long cartId, Long productId, int quantity);
    void removeProductFromCart(Long cartId, Long productId);
    void checkoutCart(Long cartId);
}






