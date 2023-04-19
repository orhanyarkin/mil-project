package com.orhan.project.orm.layers.data.repository;

import com.orhan.project.orm.layers.data.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    CartProduct findByCartIdAndProduct(Long cartId, Long productId);
}



