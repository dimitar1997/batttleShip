package com.example.batttleship.models.biding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginBidingModel {
    private String username;
    private String password;

    public LoginBidingModel() {
    }

    @NotNull
    @Size(min = 3, max = 10)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(min = 4)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
