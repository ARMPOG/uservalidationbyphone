package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String mainPage  (ModelMap map) throws ResourceNotFoundException {
        map.addAttribute("registeredUser", new User());;
        return "index";
    }
}
