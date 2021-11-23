package com.example.batttleship.models.service;

import com.example.batttleship.models.entity.Category;
import com.example.batttleship.models.entity.User;

import java.time.LocalDate;

public class AddShipServiceModel {
    private String name;
    private long health;
    private long power;
    private LocalDate created;
    private Category category;
    private User user;

    public AddShipServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
