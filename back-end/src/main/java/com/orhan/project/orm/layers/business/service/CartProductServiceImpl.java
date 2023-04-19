package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.data.entity.Cart;
import com.orhan.project.orm.layers.data.entity.CartProduct;
import com.orhan.project.orm.layers.data.entity.Product;
import com.orhan.project.orm.layers.data.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImpl implements CartProductService {
    private CartProductRepository cartProductRepository;

    @Autowired
    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public void addProductToCart(Long cartId, Long productId, int quantity) {
        CartProduct cartProduct = cartProductRepository.findByCartIdAndProduct(cartId, productId);
        if (cartProduct != null) {
            cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
            cartProductRepository.save(cartProduct);
        } else {
            Cart cart = new Cart();
            cart.setId(cartId);

            Product product = new Product();
            product.setProductId(productId);

            cartProduct = new CartProduct(cart, product, quantity);
            cartProductRepository.save(cartProduct);
        }
    }

    @Override
    public void removeProductFromCart(Long cartId, Long productId) {
        CartProduct cartProduct = cartProductRepository.findByCartIdAndProduct(cartId, productId);
        if (cartProduct != null) {
            cartProductRepository.delete(cartProduct);
        }
    }
}

