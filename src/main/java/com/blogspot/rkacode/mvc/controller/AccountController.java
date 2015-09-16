package com.blogspot.rkacode.mvc.controller;

import com.blogspot.rkacode.mvc.entity.User;
import com.blogspot.rkacode.mvc.model.RegisterModel;
import com.blogspot.rkacode.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/account/login")
    public ModelAndView loginAction() {
        return new ModelAndView("account/login");
    }

    @RequestMapping(value = "account/register", method = RequestMethod.GET)
    public ModelAndView registerForm() {
        ModelAndView view = new ModelAndView("account/register");
        view.addObject("model", new RegisterModel());
        return view;
    }

    @RequestMapping(value = "account/register", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@ModelAttribute RegisterModel model) {
        User user = new User(model.getEmail(), model.getNickname(), model.getPassword());
        userService.save(user);

        return new ModelAndView("redirect:/account/login");
    }

}
