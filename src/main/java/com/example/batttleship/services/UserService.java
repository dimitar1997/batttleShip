package com.example.batttleship.services;

import com.example.batttleship.models.biding.LoginBidingModel;
import com.example.batttleship.models.service.RegisterServiceModel;
import com.example.batttleship.models.service.UserServiceLoginModel;

public interface UserService {
    void registerUser(RegisterServiceModel registerServiceModel);

    UserServiceLoginModel findLoginUser(LoginBidingModel loginBindingModel);

}
