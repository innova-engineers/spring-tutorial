package com.innova.controller;

import com.innova.beans.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    private final String HELLO_TEMPLATE = "Hello %s";

    /*@RequestMapping(
            value = "/hello",
            method = RequestMethod.GET
    )*/
    @GetMapping(path = "/hello/{name}")
    public User sayHello(@PathVariable String name){
        return new User(String.format(HELLO_TEMPLATE, name));
    }
}
