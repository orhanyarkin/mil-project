package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CartDto;
import com.orhan.project.orm.layers.business.dto.CartProductDto;
import com.orhan.project.orm.layers.data.entity.Cart;
import com.orhan.project.orm.layers.data.entity.CartProduct;
import com.orhan.project.orm.layers.data.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
  @Autowired
  private CartRepository cartRepository;
  @Autowired
  private CartProductService cartProductService;

  @Override
  public CartDto getCartById(Long cartId) {
    Cart cart = cartRepository.findById(cartId).orElse(null);
    if (cart != null) {
      CartDto cartDto = new CartDto();
      cartDto.setId(cart.getId());
      List<CartProductDto> cartProductDtos = new ArrayList<>();
      for (CartProduct cartProduct : cart.getProducts()) {
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setProductId(cartProduct.getId());
        cartProductDto.setProductId(cartProduct.getProduct().getProductId());
        cartProductDto.setQuantity(cartProduct.getQuantity());
        cartProductDtos.add(cartProductDto);
      }

      cartDto.setCartProducts(cartProductDtos);
      return cartDto;
    }

    return null;
  }

  @Override
  public void addProductToCart(Long cartId, Long productId, int quantity) {
    cartProductService.addProductToCart(cartId, productId, quantity);
  }

  @Override
  public void removeProductFromCart(Long cartId, Long productId) {
    cartProductService.removeProductFromCart(cartId, productId);
  }

  @Override
  public void checkoutCart(Long cartId) {
    Cart cart = cartRepository.findById(cartId).orElse(null);
    if (cart != null) {
      cartRepository.delete(cart);
    }
  }
}




















































