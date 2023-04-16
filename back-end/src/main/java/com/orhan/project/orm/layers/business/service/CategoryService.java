package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CategoryDto;
import com.orhan.project.orm.layers.business.dto.CategoryDtoList;

public interface CategoryService {
    void create(CategoryDto categoryDto);
    void update(CategoryDto categoryDto);
    void delete(long categoryId);
    CategoryDtoList list();
    CategoryDto getCategoryById(long categoryId);

}
