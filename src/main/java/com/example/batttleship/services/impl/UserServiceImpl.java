package com.example.batttleship.services.impl;


import com.example.batttleship.models.biding.LoginBidingModel;
import com.example.batttleship.models.entity.User;
import com.example.batttleship.models.service.RegisterServiceModel;
import com.example.batttleship.models.service.UserServiceLoginModel;
import com.example.batttleship.repository.UserRepository;
import com.example.batttleship.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterServiceModel registerServiceModel) {
        User user = modelMapper
                .map(registerServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(registerServiceModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserServiceLoginModel findLoginUser(LoginBidingModel loginBindingModel) {
        User user = userRepository.findByUsernameAndPassword(
                loginBindingModel.getUsername(),
                loginBindingModel.getPassword())
                .orElse(null);
        if (user == null){
            return null;
        }else {
            return modelMapper.map(user,UserServiceLoginModel.class);
        }
    }

}
