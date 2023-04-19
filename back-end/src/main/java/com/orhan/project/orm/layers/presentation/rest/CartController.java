package com.orhan.project.orm.layers.presentation.rest;

import com.orhan.project.orm.layers.business.dto.CartDto;
import com.orhan.project.orm.layers.business.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/get/{cartId}")
    public CartDto getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @PostMapping("/add/{cartId}/{productId}")
    public void addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam Integer quantity) {
        cartService.addProductToCart(cartId, productId, quantity);
    }

    @PostMapping("/remove/{cartId}/{productId}")
    public void removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        cartService.removeProductFromCart(cartId, productId);
    }

    @PostMapping("/checkout")
    public void checkoutCart(@RequestParam Long cartId) {
        cartService.checkoutCart(cartId);
    }
}










