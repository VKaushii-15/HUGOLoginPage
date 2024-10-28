package com.example.HUGOTravelPlanner.controller;

import com.example.HUGOTravelPlanner.model.User;
import com.example.HUGOTravelPlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public RedirectView registerUser(
        @RequestParam("username") String username,
        @RequestParam("phoneNumber") String phoneNumber,
        @RequestParam("email") String email
    ) {
        try {
            userService.saveUser(username,phoneNumber,email);
            return new RedirectView("/home.html");
        } catch (Exception e) {
            e.printStackTrace(); 
            return new RedirectView("/error.html"); 
        }
    }
}

