package com.orhan.project.orm.layers.data.repository;

import com.orhan.project.orm.layers.data.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {
}
