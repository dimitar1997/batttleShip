package com.example.batttleship.services.impl;

import com.example.batttleship.models.entity.User;
import com.example.batttleship.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleShipImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public BattleShipImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return mapToUserDetails(user);
    }

    private static UserDetails mapToUserDetails(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));
        return new UserDetailsIpm(user.getUsername(),
                user.getPassword(), grantedAuthorities);
    }
}
