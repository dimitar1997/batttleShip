package com.example.batttleship.repository;

import com.example.batttleship.models.entity.Category;
import com.example.batttleship.models.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryEnum category);
}
