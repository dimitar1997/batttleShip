package com.example.batttleship.models.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryEnum name;
    private String description;

    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
