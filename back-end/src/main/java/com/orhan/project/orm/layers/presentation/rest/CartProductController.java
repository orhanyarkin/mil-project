package com.orhan.project.orm.layers.presentation.rest;

import com.orhan.project.orm.layers.business.service.CartProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/product")
public class CartProductController {
    private final CartProductService cartProductService;

    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @PostMapping("/add/{cartId}/{productId}/{quantity}")
    public ResponseEntity<Void> addProductToCart(
            @PathVariable("cartId") Long cartId,
            @PathVariable("productId") Long productId,
            @PathVariable("quantity") int quantity) {

        cartProductService.addProductToCart(cartId, productId, quantity);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/remove/{cartId}/{productId}")
    public ResponseEntity<Void> removeProductFromCart(
            @PathVariable("cartId") Long cartId,
            @PathVariable("productId") Long productId) {

        cartProductService.removeProductFromCart(cartId, productId);

        return ResponseEntity.noContent().build();
    }
}

