package com.orhan.project.orm.layers.data.repository;

import com.orhan.project.orm.layers.data.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    Optional<Cart> findById(int cartId);
}
