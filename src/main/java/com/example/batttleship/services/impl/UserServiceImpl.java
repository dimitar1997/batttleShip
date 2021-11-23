package com.example.batttleship.services.impl;



import com.example.batttleship.models.entity.User;
import com.example.batttleship.models.service.RegisterServiceModel;
import com.example.batttleship.repository.UserRepository;
import com.example.batttleship.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final BattleShipImpl battleShip;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, BattleShipImpl battleShip) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.battleShip = battleShip;
    }

    @Override
    public void registerUser(RegisterServiceModel registerServiceModel) {
        User user = modelMapper
                .map(registerServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(registerServiceModel.getPassword()));
        userRepository.save(user);

        UserDetails principal = battleShip.loadUserByUsername(user.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                user.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);


    }

    @Override
    public void findLoginUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElse(null);




    }

}
