package com.example.batttleship.dbInit;

import com.example.batttleship.services.CategoryService;
import com.example.batttleship.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {
    private final CategoryService categoryService;
    private final UserService userService;

    public DataBaseInit(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
        userService.initializationUsers();

    }
}
