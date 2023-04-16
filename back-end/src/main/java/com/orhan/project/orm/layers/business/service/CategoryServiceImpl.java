package com.orhan.project.orm.layers.business.service;

import com.orhan.project.orm.layers.business.dto.CategoryDto;
import com.orhan.project.orm.layers.business.dto.CategoryDtoList;
import com.orhan.project.orm.layers.data.entity.Category;
import com.orhan.project.orm.layers.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(CategoryDto categoryDto) {
        Category category = toEntity(categoryDto);
        categoryRepository.save(category);
        categoryDto.setCategoryId(category.getCategoryId());
    }

    @Override
    public void update(CategoryDto categoryDto) {
        Category category = toEntity(categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public void delete(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDtoList list() {
        CategoryDtoList categoryDtoList = new CategoryDtoList();
        categoryDtoList.setCategoryDtoList(new ArrayList<>());
        for (Category category : categoryRepository.findAll()) {
            CategoryDto categoryDto = toDto(category);
            categoryDtoList.getCategoryDtoList().add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public CategoryDto getCategoryById(long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            return toDto(categoryOptional.get());
        }
        return null;
    }

    private Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }

    private CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }
    }