package com.innova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Innova on 02-09-2017.
 */
@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
