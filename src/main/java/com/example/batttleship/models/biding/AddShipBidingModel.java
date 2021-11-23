package com.example.batttleship.models.biding;

import com.example.batttleship.models.entity.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddShipBidingModel {
    private String name;
    private Integer power;
    private Integer health;
    private LocalDate created;
    private CategoryEnum category;

    public AddShipBidingModel() {
    }

    @Size(min = 2, max = 10)
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    @NotNull
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Positive
    @NotNull
    public Integer getHealth() {
        return health;
    }


    public void setHealth(Integer health) {
        this.health = health;
    }
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
