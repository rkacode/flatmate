package com.blogspot.rkacode.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/"})
    public String index() {
        return "home/welcome";
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "home/home";
    }
}
