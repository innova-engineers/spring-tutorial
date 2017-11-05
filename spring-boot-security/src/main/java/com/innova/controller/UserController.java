package com.innova.controller;

import com.innova.model.User;
import com.innova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/details")
    public User getDetails(Authentication auth) {
        UserDetails u = (UserDetails) auth.getPrincipal();
        return userService.findByUsername(u.getUsername());
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }
}
