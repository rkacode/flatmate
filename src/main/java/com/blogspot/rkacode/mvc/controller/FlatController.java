package com.blogspot.rkacode.mvc.controller;

import com.blogspot.rkacode.mvc.entity.Flat;
import com.blogspot.rkacode.mvc.entity.User;
import com.blogspot.rkacode.mvc.model.FlatCreateModel;
import com.blogspot.rkacode.mvc.model.FlatHomeModel;
import com.blogspot.rkacode.mvc.security.LoggedUserProvider;
import com.blogspot.rkacode.mvc.service.FlatService;
import com.blogspot.rkacode.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlatController {

    @Autowired
    FlatService flatService;

    @Autowired
    UserService userService;

    @Autowired
    LoggedUserProvider loggedUserProvider;

    @RequestMapping(value = "/flat/create", method = RequestMethod.GET)
    public ModelAndView createFlatForm() {
        ModelAndView view = new ModelAndView("flat/create");
        view.addObject("model", new FlatCreateModel());
        return view;
    }

    @RequestMapping(value = "/flat/create", method = RequestMethod.POST)
    public ModelAndView createFlatSubmit(@ModelAttribute FlatCreateModel model) {
        Flat flat = new Flat();
        flat.setName(model.getName());
        User user = userService.findByEmail(loggedUserProvider.getLoggedUser().getUsername());
        flat.setOwner(user);
        flatService.save(flat);

        user.setFlat(flat);
        userService.save(user);

        return new ModelAndView("redirect:/flat/home/" + flat.getId());
    }

    @RequestMapping(value = "/flat/home/{id}")
    public ModelAndView home(@PathVariable String id) {
        Flat flat = flatService.find(id);
        ModelAndView view = new ModelAndView("flat/home");

        UserDetails currentUser = loggedUserProvider.getLoggedUser();

        FlatHomeModel flatHomeModel = new FlatHomeModel();
        flatHomeModel.setOwner(flat.getOwner().getEmail().equals(currentUser.getUsername()));
        flatHomeModel.setUsers(flat.getUsers());
        flatHomeModel.setName(flat.getName());

        view.addObject("flat", flatHomeModel);

        return view;
    }

    @RequestMapping(value = "/flat/change/{id}")
    public ModelAndView change(@PathVariable String id) {
        Flat flat = flatService.find(id);
        flat.setName("test changed");
        return new ModelAndView("redirect:/flat/home/" + id);
    }



    @RequestMapping(value = "/flat/addUser")
    public ModelAndView addUser() {
        String email = "ed@gm";

        String id = userService.findByEmail(email).getId();

        String name = "test";

        String id2 = flatService.findByName(name).getId();

        flatService.addUser(id2, id);

        return new ModelAndView("redirect:/flat/home");
    }

}
