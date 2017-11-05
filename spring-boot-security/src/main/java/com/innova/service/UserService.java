package com.innova.service;

import com.innova.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User add(User user);
    User findByUsername(String username);
}
