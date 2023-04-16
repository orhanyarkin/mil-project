package com.orhan.project.orm.layers.data.repository;

import com.orhan.project.orm.layers.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long> {
    @Query("select e from Product e where e.category.categoryId = :categoryId")
    public List<Product> findByCategory(@Param("categoryId") long categoryId);

    @Query("select count(e.productId) from Product e where e.category.categoryId = :categoryId")
    public int countByCategory(long categoryId);

}
