package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.data.entity.Cart;

public interface CartService {
    Cart getOrCreateCart(Long cartId);
    Cart addProductToCart(Long cartId, Long productId);
    Cart removeProductFromCart(Long cartId, Long productId);
    String checkoutCart(Long cartId);

    Cart getCartById(Long id);
}
