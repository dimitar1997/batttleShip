package com.example.batttleship.services.impl;

import com.example.batttleship.models.entity.Category;
import com.example.batttleship.models.entity.CategoryEnum;
import com.example.batttleship.repository.CategoryRepository;
import com.example.batttleship.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        Category category = new Category();
                        category.setName(categoryEnum);
                        categoryRepository.save(category);
                    });
        }
    }
}
