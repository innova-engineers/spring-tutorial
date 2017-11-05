package com.innova.service.impl;

import com.innova.repository.UserRepository;
import com.innova.model.User;
import com.innova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthority(user));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthority(User user) {
        Collection<? extends GrantedAuthority> authorities;
        authorities = Arrays.asList(() -> user.getRole().toString());
        return authorities;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findOne(username);
    }

}
