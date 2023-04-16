package com.orhan.project.orm.layers.business.service;


import com.orhan.project.orm.layers.data.entity.Cart;
import com.orhan.project.orm.layers.data.entity.CartStatus;
import com.orhan.project.orm.layers.data.entity.Product;
import com.orhan.project.orm.layers.data.repository.CartRepository;
import com.orhan.project.orm.layers.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart getCartById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            return cart.get();
        } else {
            return getOrCreateCart(id);
        }
    }
    @Override
    public Cart getOrCreateCart(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            return optionalCart.get();
        }
        return cartRepository.save(new Cart(cartId,CartStatus.NEW));
    }

    @Override
    public Cart addProductToCart(Long cartId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        Cart cart = getOrCreateCart(cartId);
        cart.addProduct(product);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        Cart cart = getOrCreateCart(cartId);
        cart.removeProduct(product);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public String checkoutCart(Long cartId) {
        Cart cart = getOrCreateCart(cartId);
        cart.setCartStatus(CartStatus.COMPLETED);
        cartRepository.save(cart);
        return null;
    }
}
